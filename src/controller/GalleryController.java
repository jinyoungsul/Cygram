package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.GalleryService;
import vo.Gallery;

@Controller
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	public void setGalleryService(GalleryService galleryService){
		this.galleryService=galleryService;
	}
	//----------------------------------------------------------//
	
	@RequestMapping("/galleryList.do")
	public ModelAndView galleryList(@RequestParam(value="page",defaultValue="1") int page){
		ModelAndView mv = new ModelAndView("gallery_list");
		mv.addObject("galleryPage", galleryService.makePage(page));
		return mv;
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm(HttpSession session){
		return "write_form";
	}
	
	@RequestMapping("/write.do")
	public ModelAndView write(HttpSession session, Gallery gallery){
		ModelAndView mv = new ModelAndView("write_result");
		mv.addObject("galleryNo", galleryService.write(gallery));
		return mv;
	}
	
	@RequestMapping("/read.do")
	public ModelAndView read(HttpSession session,int galleryNo){
		Gallery gallery = galleryService.read(galleryNo);
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("gallery", gallery);
		return mv;
	}
	
	
}
