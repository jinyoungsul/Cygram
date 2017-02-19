package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.FriendsService;
import service.MiniHomepageService;
import vo.Friend;
import vo.MiniHomepage;

@Controller
public class MiniHomepageController {
	@Autowired
	private MiniHomepageService homepageService;
	@Autowired
	private FriendsService friendsService;
	
	public void setService(MiniHomepageService homepageService) {
		this.homepageService = homepageService;
	}
	public void setFriendsService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}

	@RequestMapping(value="/miniHomepage.do",method=RequestMethod.POST)
	public ModelAndView miniHomepage(String id,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String friendId = id;
		String myId = (String)session.getAttribute("loginId");
		System.out.println("로그인 세션 확인 : "+myId);
		
		///////////////방문자 수 (쿠키)//////////////////////////
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			//쿠키 서치
			boolean create = true;
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(myId+friendId)){
					System.out.println("쿠키 찾음 id = "+cookie.getValue());
					create = false;
				}
			}
			if(create){
				//쿠키 생성
				Cookie cookie = new Cookie(myId+friendId,"visit");
				Date expireday = new Date();
				expireday = new Date(expireday.getTime()/86400000*86400000+54000000);
				int expire = (int)(((expireday.getTime()/86400000*86400000)+54000000) - new Date().getTime());
				cookie.setMaxAge(expire);
				response.addCookie(cookie);
				homepageService.increaseTodayTotal(id);
				System.out.println("쿠키 생성 = "+cookie.getName());
			}
			
		} else {
			//쿠키 생성
			Cookie cookie = new Cookie(myId+friendId,"visit");
			Date expireday = new Date();
			expireday = new Date(expireday.getTime()/86400000*86400000+54000000);
			int expire = (int)(((expireday.getTime()/86400000*86400000)+54000000) - new Date().getTime());
			cookie.setMaxAge(expire);
			response.addCookie(cookie);
			homepageService.increaseTodayTotal(id);
			System.out.println("쿠키 생성 else = "+cookie.getName());
		}
		Friend friend = friendsService.checkFriend(myId,friendId);
		System.out.println("선청되어 있는 일촌인가? : "+friend);
		MiniHomepage miniHomepage = homepageService.selectMiniHomepage(friendId);
		mv.setViewName("minihomepage");
		mv.addObject("friend", friend);
		mv.addObject("miniHomepage", miniHomepage);
		return mv;
	}
	@RequestMapping(value="/minihomepageSearch.do")
	public ModelAndView miniHomepageSearch(
			@RequestParam(value="keyword",defaultValue="")String keyword ){
		ModelAndView mv = new ModelAndView();
		List<MiniHomepage> homepageList = homepageService.selectMiniHomepageList(keyword);
		mv.addObject("homepageList", homepageList);
		mv.setViewName("homepageList");
		return mv;
	}
	@RequestMapping(value="homepageTitleUpdate.do",method=RequestMethod.POST)
	public @ResponseBody int homepageTitleUpdate(String id,String title){
		int result = homepageService.titleUpdate(id,title);
		return result;
	}
}
