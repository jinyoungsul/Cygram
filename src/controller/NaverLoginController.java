package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import service.MemberService;
import service.MiniHomepageService;
import vo.Member;

@Controller
public class NaverLoginController {
	final String client_id = "_dvIHsQLwxDx9HAV1Pz_";
	final String client_secret = "MvHiUqIRh5";
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private MiniHomepageService homepageService;
	
	public void setService(MemberService service) {
		this.service = service;
	}
	
	public void setHomepageService(MiniHomepageService homepageService) {
		this.homepageService = homepageService;
	}

	@RequestMapping(value = "/naverLogin.do")
	public ModelAndView login(HttpSession session) {

		String redirect_uri = null;
		// 상태 토큰으로 사용할 랜덤 문자열 생성
		String state = generateState();
		// 세션 또는 별도의 저장 공간에 상태 토큰을 저장
		session.setAttribute("state", state);
		try {
			redirect_uri = URLEncoder.encode("http://127.0.0.1:8088/Cygram/naverCallBack.do", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?client_id=" + client_id
				+ "&response_type=code&redirect_uri=" + redirect_uri + "&state=" + state;
		System.out.println(apiURL);
		return new ModelAndView("login", "apiURL", apiURL);
	}

	@RequestMapping(value = "/naverCallBack.do")
	public ModelAndView callBack(HttpSession session, HttpServletRequest request) {
		System.out.println("콜백호출");
		ModelAndView mv = new ModelAndView();
		String state = request.getParameter("state");
		System.out.println("콜백 응답으로 온 상태코드" + state);
		// 세션 또는 별도의 저장 공간에서 상태 토큰을 가져옴
		String storedState = (String) session.getAttribute("state");
		System.out.println("세션에 저장된 상태코드" + storedState);
		StringBuffer res = null;
		if (!state.equals(storedState)) {
			// 401 unauthorized
		} else {
			String code = request.getParameter("code");
			String apiURL = "https://nid.naver.com/oauth2.0/token?client_id=" + client_id + "&client_secret="
					+ client_secret + "&grant_type=authorization_code&state=" + state + "&code=" + code;
			URL url;

			try {
				url = new URL(apiURL);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					res.append(inputLine);
				}
				br.close();
				
				if(con.getResponseCode()==200){
					ObjectMapper mapper = new ObjectMapper();
					JsonNode rootNode = mapper.readTree(res.toString());
					String access_token = rootNode.path("access_token").textValue();
					String refresh_token = rootNode.path("refresh_token").textValue();
					String token_type = rootNode.path("token_type").textValue();
					String expires_in = rootNode.path("expires_in").textValue();
					
					//접근토큰으로 사용자 프로필 조회
					apiURL = "https://openapi.naver.com/v1/nid/me";
					url = new URL(apiURL);
					con = (HttpURLConnection) url.openConnection();
					con.setRequestProperty("Authorization", token_type + " " + access_token);
					
					br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					res = new StringBuffer();
					while ((inputLine = br.readLine()) != null) {
						res.append(inputLine);
					}
					br.close();
					
					if(con.getResponseCode()==200){
						mapper = new ObjectMapper();
						rootNode = mapper.readTree(res.toString());
						JsonNode responseNode = rootNode.path("response");
						String email = responseNode.path("email").textValue();
						String name = responseNode.path("name").textValue();
						System.out.println(responseNode);
						mv.addObject("email", email);
						mv.addObject("name", name);
						mv.setViewName("callBack");
					}
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mv;
	}
	@RequestMapping(value="/naverJoin.do", method=RequestMethod.POST)
	public ModelAndView NaverJoin(Member member,HttpSession session ){
		
		ModelAndView mv = new ModelAndView();
		
		
		System.out.println("네이버 가입"+member.toString());
		
		//////////////////가입 되어 있는지 한번 확인////////////
		Member savedMember = new Member();
		savedMember = service.selectMember(member.getId());
		System.out.println("아이디 찾았어?:"+savedMember);
		if(savedMember!=null){	//아이디가 존재 하면 바로 메인 이동 
			System.out.println("네이버 아이디 존재");
			session.setAttribute("loginId", savedMember.getId());
			mv.addObject("member", savedMember);
			mv.setViewName("main");
		} else if(savedMember==null){	//아이디가 존재 하지 않으면
			System.out.println("네이버 아이디 X");
			System.out.println("네이버 회원가입 :"+savedMember);
			member.setEmail("null");	//왜 널값이 들어가면 안됨?
			member.setPassword("null");	//왜 널값이 들어가면 안됨?
			member.setPhone("null");	//왜 널값이 들어가면 안됨?
			if(service.join(member)){	//가입 후 메인 이동
				session.setAttribute("loginId", member.getId());
				System.out.println("네이버 가입시 미니홈피");
				homepageService.createMiniHomepage(member.getId());
				mv.addObject("member", member);
				mv.setViewName("main");
			} else {
				mv.setViewName("join_error");	//가입 실패시 에러
			}
		}
		return mv;
	}
	
	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
	
	
}
