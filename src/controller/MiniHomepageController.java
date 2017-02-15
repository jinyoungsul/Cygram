package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
