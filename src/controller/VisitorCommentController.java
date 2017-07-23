package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.VisitorCommentService;
import vo.VisitorComment;

@Controller
public class VisitorCommentController {
	@Autowired
	private VisitorCommentService visitorCommentService;
	public void setVisitorCommentService(VisitorCommentService visitorCommentService) {
		this.visitorCommentService = visitorCommentService;
	}
	
	@RequestMapping(value="/writeCommentVisitor.do")
	public @ResponseBody List<VisitorComment> visitorCommentUpdate(
			String myId,
			@RequestParam(value="visitorNo",defaultValue="0")int visitorNo,
			@RequestParam(value="content",defaultValue="")String content){

		VisitorComment visitorComment = new VisitorComment();
		visitorComment.setVisitorNo(visitorNo);
		visitorComment.setMyId(myId);
		visitorComment.setContent(content);
		if(content.length()>0)
			visitorCommentService.insertVisitorComment(visitorComment);			
		
		List<VisitorComment> visitorCommentList = visitorCommentService.selectVisitorComment(visitorNo);
		
		return visitorCommentList;
	}
	@RequestMapping(value="/deleteCommentVisitor.do")
	public @ResponseBody List<VisitorComment> visitorCommentDelete(
			@RequestParam(value="visitorNo",defaultValue="0")int visitorNo,
			@RequestParam(value="visitorCommentNo",defaultValue="")int visitorCommentNo){
		System.out.println("다이어리 댓글 삭제"+visitorCommentNo);
		visitorCommentService.deleteVisitorComment(visitorCommentNo);
		List<VisitorComment> visitorCommentList = visitorCommentService.selectVisitorComment(visitorNo);
		
		return visitorCommentList;
	}
}
