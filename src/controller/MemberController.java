package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import repository.FriendsDao;
import service.MemberService;
import vo.Friend;
import vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private FriendsDao dao;
	
	public void setService(MemberService service) {
		this.service = service;
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
		if(service.join(member)){
			mv.setViewName("join_success");
			mv.addObject("joinMemberInfo", member);
		}else{
			mv.setViewName("join_error");
		}
		return mv;
	}
	@RequestMapping("/login.do")
	public ModelAndView login(String id,String password){
		ModelAndView mv = new ModelAndView();
		System.out.println("로그인 아이디 : "+id);
		System.out.println("로그인 비밀번호 : "+password);
		
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




