package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.FriendsService;
import service.MiniHomepageService;
import vo.Friend;
import vo.MiniHomepage;

@Controller
public class FriendsController {
	@Autowired
	private FriendsService friendsService;
	@Autowired
	private MiniHomepageService homepageSerivce;
	
	public void setFriendService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}
	
	public void setHomepageSerivce(MiniHomepageService homepageSerivce) {
		this.homepageSerivce = homepageSerivce;
	}
	@RequestMapping("/friends.do")
	public ModelAndView friends(String id){

		ModelAndView mv = new ModelAndView();
		List<Friend> sendFriendsList = friendsService.selectSendFriendsList(id);
		List<Friend> receiveFriendsList = friendsService.selectReceiveFriendsList(id);
		mv.addObject("sendFriendsList",sendFriendsList);
		mv.addObject("receiveFriendsList",receiveFriendsList);
		mv.setViewName("friends");
		return mv;
	}
	@RequestMapping("/friendsPlusForm.do")
	public ModelAndView friendsPlusForm(String myId,String friendId){
		ModelAndView mv = new ModelAndView();
		MiniHomepage myInfo = homepageSerivce.selectMiniHomepage(myId);
		MiniHomepage friendInfo = homepageSerivce.selectMiniHomepage(friendId);
		System.out.println("일촌신청 내정보 : "+myInfo);
		System.out.println("일촌신청 상대정보 : "+friendInfo);
		mv.addObject("myInfo", myInfo);
		mv.addObject("friendInfo", friendInfo);
		mv.setViewName("friendsPlus");
		return mv;
	}
	@RequestMapping("/friendsPlus.do")
	public ModelAndView friendsPlus(Friend my){
		ModelAndView mv = new ModelAndView();
		my.setAction("send");
		my.setAccept("F");
		//////////친구 정보///////////////
		Friend friend = new Friend();
		friend.setMyId(my.getFriendId());
		friend.setMyNickname(my.getFriendNickname());
		friend.setFriendId(my.getMyId());
		friend.setFriendNickname(my.getMyNickname());
		friend.setAction("receive");
		friend.setAccept("F");
		////////////////////////////////
		friendsService.insertFriends(my);
		friendsService.insertFriends(friend);
		return mv;
	}
}
