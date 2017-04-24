package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.CommentDiaryDao;
import vo.CommentDiary;

@Component
public class CommentDiaryService {
	@Autowired
	private CommentDiaryDao commentDiaryDao;
	public void setCommentDiaryDao(CommentDiaryDao commentDiaryDao){
		this.commentDiaryDao=commentDiaryDao;
	}

	//---------------------------------//
	
	public int insertCommentDiary(CommentDiary commentDiary) {
		return commentDiaryDao.insertCommentDiary(commentDiary);
	}
	
	public List<CommentDiary> selectCommentDiary(int diaryNo){
		return commentDiaryDao.selectCommentDiary(diaryNo);
	}

}
