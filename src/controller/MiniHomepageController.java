package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.MiniHomepageService;
import vo.MiniHomepage;

@Controller
public class MiniHomepageController {
	@Autowired
	private MiniHomepageService homepageService;

	public void setService(MiniHomepageService homepageService) {
		this.homepageService = homepageService;
	}
	
	@RequestMapping(value="/miniHomepage.do")
	public ModelAndView miniHomepage(String id){
		ModelAndView mv = new ModelAndView();
		MiniHomepage miniHomepage = homepageService.selectMiniHomepage(id);
		mv.setViewName("minihomepage");
		mv.addObject("miniHomepage", miniHomepage);
		return mv;
	}
}
