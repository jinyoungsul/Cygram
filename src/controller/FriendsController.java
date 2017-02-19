package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	@RequestMapping(value="/friends.do")
	public ModelAndView friends(String id){

		ModelAndView mv = new ModelAndView();
		List<Friend> sendFriendsList = friendsService.selectSendFriendsList(id);
		List<Friend> receiveFriendsList = friendsService.selectReceiveFriendsList(id);
		List<Friend> friendsList = friendsService.selectAcceptFriends(id);
		System.out.println("일촌신청 보기:"+id);
		mv.addObject("sendFriendsList",sendFriendsList);
		mv.addObject("receiveFriendsList",receiveFriendsList);
		mv.addObject("friendsList", friendsList);
		System.out.println("sendFriendsList.size " +sendFriendsList.size());
		System.out.println("receiveFriendsList.size " +receiveFriendsList.size());
		
		mv.setViewName("friends");
		
		return mv;
	}
	@RequestMapping(value="/friendsJson.do",method=RequestMethod.POST)
	public @ResponseBody List<Friend> friendsAjax(
			@RequestParam("id") String id){
		System.out.println("JSON리퀘스트 매핑");
		List<Friend> friendsList = friendsService.selectAcceptFriends(id);
		System.out.println("일촌신청 보기:"+id);
		
		ObjectMapper mapper = new ObjectMapper();
		String friendsJson;
		List<String> friendsJsonList = new ArrayList<>();
		try {
			for(Friend friend : friendsList){
				friendsJson = mapper.writeValueAsString(friend);
				friendsJsonList.add(friendsJson);
			}
			System.out.println("Json 일촌 "+friendsJsonList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendsList;
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
		ModelAndView mv = new ModelAndView("friendPlusSuccess");
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
	@RequestMapping(value="/friendsCancel.do")
	public ModelAndView friendsCancel(
		int friendNo){
		ModelAndView mv = new ModelAndView("cancelSuccess");
		System.out.println("친구신청 취소 : "+friendNo);
		Friend friend = friendsService.selectFriends(friendNo);
		String myId = friend.getMyId();
		String friendId = friend.getFriendId();
		int otherFriendNo = friendsService.checkFriend(friendId, myId).getFriendNo();
		System.out.println("상대방 입장 친구신청  : "+otherFriendNo);
		friendsService.cancelFriends(friendNo);
		friendsService.cancelFriends(otherFriendNo);
		return mv;
	}
	@RequestMapping(value="/friendsDelete.do",method=RequestMethod.POST)
	public @ResponseBody int friendsDelete(
		int friendNo){
		System.out.println("친구신청 취소 : "+friendNo);
		Friend friend = friendsService.selectFriends(friendNo);
		String myId = friend.getMyId();
		String friendId = friend.getFriendId();
		int otherFriendNo = friendsService.checkFriend(friendId, myId).getFriendNo();
		System.out.println("상대방 입장 친구신청  : "+otherFriendNo);
		friendsService.cancelFriends(friendNo);
		friendsService.cancelFriends(otherFriendNo);
		return 1;
	}
	@RequestMapping("/friendsAccept.do")
	public ModelAndView friendsAccept(int friendNo){
		ModelAndView mv = new ModelAndView("acceptSuccess");
		System.out.println("친구신청 수락 : "+friendNo);
		Friend friend = friendsService.selectFriends(friendNo);
		String myId = friend.getMyId();
		String friendId = friend.getFriendId();
		int otherFriendNo = friendsService.checkFriend(friendId, myId).getFriendNo();
		System.out.println("상대방 입장 친구수락  : "+otherFriendNo);
		friendsService.acceptFriends(friendNo);
		friendsService.acceptFriends(otherFriendNo);
		return mv;
	}
	
}
