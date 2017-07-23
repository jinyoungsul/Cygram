package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.VisitorCommentDao;
import repository.VisitorDao;
import vo.CommentDiary;
import vo.Diary;
import vo.Visitor;
import vo.VisitorComment;
import vo.VisitorPage;

@Component
public class VisitorService {
	@Autowired
	private VisitorDao visitorDao;
	public void setVisitorDao(VisitorDao visitorDao){
		this.visitorDao=visitorDao;
	}
	//-----------------------------------------------//
	@Autowired
	private VisitorCommentDao visitorCommentDao;
	
	public void setVisitorCommentDao(VisitorCommentDao visitorCommentDao) {
		this.visitorCommentDao = visitorCommentDao;
	}

	public int write(Visitor visitor){
		visitor.setWriteDate(new Date());
		
		int result=0;
		result=visitorDao.insert(visitor);
		return result;
	}
	
	public int modify(Visitor visitor, String id){
		visitor.setWriteDate(new Date());
		
		int result=0;
		if(id.equals(visitor.getId())){
			result=visitorDao.update(visitor); 
		}
		return result;
	}
	
	public Visitor read(int visitorNo){
		Visitor visitor = visitorDao.select(visitorNo);
		return visitor;
	}
	
	public VisitorPage makePage(int currentPage, String id){
		final int COUNT_PER_PAGE=3;
		int totalvisitorCount = visitorDao.selectVisitorCount();
		
		
		if(totalvisitorCount==0)
			return new VisitorPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		
		List<Visitor> visitorList = 
				visitorDao.selectVisitorList(startRow, endRow, id);
		for(Visitor visitor : visitorList){
			int visitorNo = visitor.getVisitorNo();
			List<VisitorComment> commentVisitorList = visitorCommentDao.selectVisitorComment(visitorNo);
			visitor.setVisitorCommentList(commentVisitorList);
		}
		int totalPage = totalvisitorCount/COUNT_PER_PAGE;
		if(totalvisitorCount%COUNT_PER_PAGE !=0)
			totalPage++;
		
		int startPage = (currentPage-1)/5*5+1;
		int endPage = startPage+4;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new VisitorPage(visitorList, startPage, endPage, currentPage, totalPage);	
	}		
	
}
