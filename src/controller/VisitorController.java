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
	public String writeVisitorForm(HttpSession session, String id){
		if(id.equals(session.getAttribute("loginId"))){
			return "write_visitor_form";
		} else {
			return null;
		}
	}
	
	@RequestMapping("/visitorList.do")
	public ModelAndView visitorList(@RequestParam(value="page",defaultValue="1") int page, String id){
		ModelAndView mv = new ModelAndView("visitor_list");
		mv.addObject("visitorPage", visitorService.makePage(page, id));
		return mv;
	}
	
	@RequestMapping(value="/writeVisitor.do", method=RequestMethod.POST)
	public ModelAndView writeVisitor(HttpSession session, Visitor visitor){
		String id =(String) session.getAttribute("loginId");
		visitor.setId(id);
		visitorService.write(visitor, id);
		ModelAndView mv = new ModelAndView("visitor_list");
		mv.addObject("visitorPage", visitorService.makePage(1, id));
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
		visitor.setId(id);
		visitorService.modify(visitor, id);
		ModelAndView mv = new ModelAndView("visitor_list");
		return mv;
	}
}
