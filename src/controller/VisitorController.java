package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.VisitorService;
import vo.Visitor;

@Controller
public class VisitorController {
	@Autowired
	private VisitorService visitorService;
	public void setvisitorService(VisitorService visitorService){
		this.visitorService = visitorService;
	}
	
	//-----------------------------------------------------//
	
	@RequestMapping("/writeVisitorForm.do")
	public ModelAndView writeVisitorForm(HttpSession session, String id){
//		if(id.equals(session.getAttribute("loginId"))){
//			
//		} else {
//			return null;
//		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("friendId", id);
		mv.setViewName("write_visitor_form");
		return mv;
	}
	
	@RequestMapping("/visitorList.do")
	public ModelAndView visitorList(@RequestParam(value="page",defaultValue="1") int page, String id){
		ModelAndView mv = new ModelAndView("visitor_list");
		System.out.println(page+','+id);
//		System.out.println("방명록 리스트"+visitorService.makePage(page, id));
//		mv.addObject("visitorPage", visitorService.makePage(page, id));
		return mv;
	}
	
	@RequestMapping(value="/writeVisitor.do", method=RequestMethod.POST)
	public ModelAndView writevisitor(HttpSession session, Visitor visitor){
		String id =(String) session.getAttribute("loginId");
		visitor.setMyId(id);
		visitorService.write(visitor, id);
		ModelAndView mv = new ModelAndView("visitor_list");
		return mv;
	}
	
	@RequestMapping("modifyVisitorForm.do")
	public String modifyVisitorForm(HttpSession session, String id) {
		if (id.equals(session.getAttribute("loginId"))) {
			return "modify_visitor_form";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/modifyVisitor.do", method = RequestMethod.POST)
	public ModelAndView modifyProfile(HttpSession session, Visitor visitor) {
		String id = (String) session.getAttribute("loginId");
		visitor.setMyId(id);
		visitorService.modify(visitor, id);
		ModelAndView mv = new ModelAndView("visitor_list");
		return mv;
	}
}
