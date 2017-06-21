package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.GalleryService;
import vo.Gallery;
import vo.GalleryImg;

@Controller
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	public void setGalleryService(GalleryService galleryService){
		this.galleryService=galleryService;
	}
	//----------------------------------------------------------//
	
	@RequestMapping("/galleryList.do")
	public ModelAndView galleryList(@RequestParam(value="page",defaultValue="1") int page,HttpSession session,String id){
		String loginId = (String) session.getAttribute("loginId");
		ModelAndView mv = new ModelAndView("gallery_list");
		mv.addObject("minihomepageId",id);
		mv.addObject("galleryPage", galleryService.makePage(page,id,loginId));
		return mv;
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm(HttpSession session){
		return "write_form";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public ModelAndView write
	(HttpServletRequest request, HttpSession session, 
			Gallery gallery){
		
		String id = (String) session.getAttribute("loginId");
		galleryService.write(request,session,gallery);
		ModelAndView mv = new ModelAndView("gallery_list");
		mv.addObject("minihomepageId", id);
		mv.addObject("fileCount", gallery.getPhotoList().size());
		mv.addObject("galleryPage", galleryService.makePage(1, id, id));
		return mv;
	}
	
	@RequestMapping("/read.do")
	public ModelAndView read(HttpSession session,int galleryNo){
		Gallery gallery = galleryService.read(galleryNo);
		ModelAndView mv = new ModelAndView("read");
		mv.addObject("gallery", gallery);
		return mv;
	}
	
	@RequestMapping("/modifyGalleryForm.do")
	public ModelAndView modifyGalleryForm(HttpSession session, int galleryNo){
		ModelAndView mv = new ModelAndView("modify_gallery_form");
		mv.addObject("gallery", galleryService.read(galleryNo));
		return mv;
	}
	
	@RequestMapping("modifyGallery.do")
	public ModelAndView modifyGallery
	(HttpServletRequest request, HttpSession session,
			Gallery gallery){
		galleryService.modify(request, gallery, session);
		return null;
	}
	
	
}
