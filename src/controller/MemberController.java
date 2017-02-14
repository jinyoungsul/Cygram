package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repository.FriendsDao;
import service.MemberService;
import service.MiniHomepageService;
import vo.Friend;
import vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private MiniHomepageService homepageService;
	@Autowired
	private FriendsDao dao;
	
	/////////////////////////////////////////////////////////
	
	public void setService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public void setHomepageService(MiniHomepageService homepageService) {
		this.homepageService = homepageService;
	}

	public void setDao(FriendsDao dao) {
		this.dao = dao;
	}

	///////////////////////////////////////////////////////
	@RequestMapping
		(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(Member member){
		ModelAndView mv = new ModelAndView();
		System.out.println("회원가입 : " +member.toString());
		if(memberService.join(member)){
			mv.setViewName("join_success");
			mv.addObject("joinMemberInfo", member);
			homepageService.createMiniHomepage(member.getId());
		}else{
			mv.setViewName("join_error");
		}
		return mv;
	}
	@RequestMapping("/login.do")
	public ModelAndView login(String id,String password,HttpSession session){
		ModelAndView mv = new ModelAndView();
		System.out.println("로그인 아이디 : "+id);
		System.out.println("로그인 비밀번호 : "+password);
		if(memberService.login(id,password)){
			session.setAttribute("loginId", id);
			Member member = memberService.selectMember(id);
			mv.addObject("member", member);
			mv.setViewName("main");
		} else{
			mv.setViewName("index");
		}
		return mv;
	}
	@RequestMapping("/friends.do")
	public ModelAndView friends(){
		String id = "sul";
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		List<Friend> sendFriendsList = dao.selectSendFriendsList(id);
		mv.addObject("sendFriendsList",sendFriendsList);
		mv.setViewName("friends");
		return mv;
	}
}




