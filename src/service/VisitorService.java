package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.VisitorDao;
import vo.Visitor;
import vo.VisitorPage;

@Component
public class VisitorService {
	@Autowired
	private VisitorDao visitorDao;
	public void setVisitorDao(VisitorDao visitorDao){
		this.visitorDao=visitorDao;
	}
	//-----------------------------------------------//
	
	public int write(Visitor visitor, String id){
		visitor.setWriteDate(new Date());
		
		int result=0;
//		if(id.equals(visitor.getMyId())){
//			result=visitorDao.insert(visitor); 
//		}
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
		
		System.out.println("total:"+totalvisitorCount);
		
		if(totalvisitorCount==0)
			return new VisitorPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		
		List<Visitor> visitorList = 
				visitorDao.selectVisitorList(startRow, endRow, id);
		
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
