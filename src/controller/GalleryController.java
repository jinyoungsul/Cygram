package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ModelAndView galleryList(@RequestParam(value="page",defaultValue="1") int page,HttpSession session){
		ModelAndView mv = new ModelAndView("gallery_list");
		mv.addObject("galleryPage", galleryService.makePage(page,(String)session.getAttribute("loginId")));
		return mv;
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm(HttpSession session){
		return "write_form";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public ModelAndView write
	(HttpServletRequest request, HttpSession session, 
			Gallery gallery, GalleryImg galleryImg){
		
		System.out.println("gallery:"+gallery);
		
		String galleryPath = request.getServletContext().getRealPath("img");
		List<GalleryImg> galleryImgList = new ArrayList<>();
		
		File dir = new File(galleryPath);
		if(dir.exists()==false){
			dir.mkdirs();
		}
		// ���� ���ε�
		//������ ���̽� ���
		for(MultipartFile f : gallery.getPhotoList()){
			String savedName = 
					galleryPath +"/"+new Random().nextInt(1000000)+f.getOriginalFilename();
			System.out.println("Cygram 위치:"+savedName.indexOf("Cygram"));
			String realPath = "/"+savedName.substring((savedName.indexOf("Cygram")));
			System.out.println("이미지경로:"+savedName.substring((savedName.indexOf("Cygram"))));
			File saveFile = new File(savedName);
			
			// ���ε�
			try {
				f.transferTo(saveFile);
				
				galleryImg = new GalleryImg();
				galleryImg.setGalleryPath(realPath);
				galleryImgList.add(galleryImg);
				
			} catch (IllegalStateException |IOException e) {
				e.printStackTrace();
			}	
		}
		
		ModelAndView mv = new ModelAndView("write_result");
		mv.addObject("galleryNo", galleryService.write(gallery, galleryImgList));
		mv.addObject("fileCount", gallery.getPhotoList().size());
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
