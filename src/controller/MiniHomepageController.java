package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value="/miniHomepage.do")
	public ModelAndView miniHomepage(String id,HttpSession session){
		ModelAndView mv = new ModelAndView();
		String friendId = id;
		MiniHomepage miniHomepage = homepageService.selectMiniHomepage(friendId);
		String myId = (String)session.getAttribute("loginId");
		System.out.println("로그인 세션 확인 : "+myId);
		Friend friend = friendsService.checkFriend(myId,friendId);
		System.out.println("선청되어 있는 일촌인가? : "+friend);
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
}
