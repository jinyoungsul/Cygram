package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.GalleryCommentService;
import vo.GalleryComment;

@Controller
public class GalleryCommentController {
	@Autowired
	private GalleryCommentService galleryCommentService;
	public void setGalleryCommentService(GalleryCommentService galleryCommentService) {
		this.galleryCommentService = galleryCommentService;
	}
	
	@RequestMapping(value="/writeGalleryComment.do")
	public @ResponseBody List<GalleryComment> GalleryCommentUpdate(
			String myId,
			@RequestParam(value="galleryNo",defaultValue="0")int galleryNo,
			@RequestParam(value="content",defaultValue="")String content){

		GalleryComment galleryComment = new GalleryComment();
		galleryComment.setGalleryNo(galleryNo);
		galleryComment.setMyId(myId);
		galleryComment.setContent(content);
		System.out.println(galleryComment);
		if(content.length()>0)
			galleryCommentService.insertGalleryComment(galleryComment);			
		
		List<GalleryComment> galleryCommentList = galleryCommentService.selectGalleryComment(galleryNo);
		System.out.println(galleryComment);
		
		return galleryCommentList;
	}	
}
