package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.GalleryCommentDao;
import repository.VisitorCommentDao;
import vo.GalleryComment;
import vo.VisitorComment;

@Component
public class VisitorCommentService {
	@Autowired
	private VisitorCommentDao visitorCommentDao;
	
	public void setVisitorCommentDao(VisitorCommentDao visitorCommentDao) {
		this.visitorCommentDao = visitorCommentDao;
	}
	
	//---------------------------------------//
	
	
	public List<VisitorComment> selectVisitorComment(int visitorNo){
		return visitorCommentDao.selectVisitorComment(visitorNo);
	}

	public int insertVisitorComment(VisitorComment visitorComment) {
		return visitorCommentDao.insertVisitorComment(visitorComment);
	}

	public int deleteVisitorComment(int visitorCommentNo) {
		return visitorCommentDao.deleteVisitorComment(visitorCommentNo);
	}

	
}
