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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
public class NaverLoginController {
	final String client_id = "_dvIHsQLwxDx9HAV1Pz_";
	final String client_secret = "MvHiUqIRh5";

	@RequestMapping(value = "/login.do")
	public ModelAndView login(HttpSession session) {

		String redirect_uri = null;
		// ?ÉÅ?Éú ?Ü†?Å∞?úºÎ°? ?Ç¨?ö©?ï† ?ûú?ç§ Î¨∏Ïûê?ó¥ ?Éù?Ñ±
		String state = generateState();
		// ?Ñ∏?Öò ?òê?äî Î≥ÑÎèÑ?ùò ???û• Í≥µÍ∞Ñ?óê ?ÉÅ?Éú ?Ü†?Å∞?ùÑ ???û•
		session.setAttribute("state", state);
		try {
			redirect_uri = URLEncoder.encode("http://127.0.0.1:8088/NaverIdLogin/callBack.do", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?client_id=" + client_id
				+ "&response_type=code&redirect_uri=" + redirect_uri + "&state=" + state;
		System.out.println(apiURL);
		return new ModelAndView("login", "apiURL", apiURL);
	}

	@RequestMapping(value = "/callBack.do")
	public ModelAndView callBack(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String state = request.getParameter("state");
		System.out.println("ÏΩúÎ∞± ?ùë?ãµ?úºÎ°? ?ò® ?ÉÅ?ÉúÏΩîÎìú" + state);
		// ?Ñ∏?Öò ?òê?äî Î≥ÑÎèÑ?ùò ???û• Í≥µÍ∞Ñ?óê?Ñú ?ÉÅ?Éú ?Ü†?Å∞?ùÑ Í∞??†∏?ò¥
		String storedState = (String) session.getAttribute("state");
		System.out.println("?Ñ∏?Öò?óê ???û•?êú ?ÉÅ?ÉúÏΩîÎìú" + storedState);
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
					
					//?†ëÍ∑ºÌÜ†?Å∞?úºÎ°? ?Ç¨?ö©?ûê ?îÑÎ°úÌïÑ Ï°∞Ìöå
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
						String nickname = responseNode.path("nickname").textValue();
						System.out.println(responseNode);
						mv.addObject("email", email);
						mv.addObject("nickname", nickname);
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

	public String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
}
