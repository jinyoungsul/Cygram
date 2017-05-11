package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CommentDiaryService;
import vo.CommentDiary;

@Controller
public class CommentDiaryController {
	@Autowired
	private CommentDiaryService commentDiaryService;
	public void setCommentDiaryService(CommentDiaryService commentDiaryService){
		this.commentDiaryService=commentDiaryService;
	}
	
	@RequestMapping(value="/writeCommentDiary.do")
	public @ResponseBody List<CommentDiary> commentDiaryUpdate(
			String myId,
			@RequestParam(value="diaryNo",defaultValue="0")int diaryNo,
			@RequestParam(value="content",defaultValue="")String content){

		CommentDiary commentDiary = new CommentDiary();
		commentDiary.setDiaryNo(diaryNo);
		commentDiary.setMyId(myId);		
		commentDiary.setContent(content);;
		
		if(content.length()>0)
			commentDiaryService.insertCommentDiary(commentDiary);
		
		List<CommentDiary> commentDiaryList = commentDiaryService.selectCommentDiary(diaryNo);
		System.out.println(commentDiary);
		
		return commentDiaryList;
		
	}
	
}
