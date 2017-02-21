package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.DiaryDao;
import vo.Diary;
import vo.DiaryPage;
import vo.Gallery;
import vo.GalleryImg;
import vo.GalleryPage;

@Component
public class DiaryService {
	@Autowired
	private DiaryDao diaryDao;
	public void setDiaryDao(DiaryDao diaryDao){
		this.diaryDao=diaryDao;
	}
	//-----------------------------------------------//
	
	public int write(Diary diary, String id){
		diary.setWriteDate(new Date());
		
		int result=0;
		if(id.equals(diary.getId())){
			result=diaryDao.insert(diary); 
		}
		return result;
	}
	
	public int modify(Diary diary, String id){
		diary.setWriteDate(new Date());
		
		int result=0;
		if(id.equals(diary.getId())){
			result=diaryDao.update(diary); 
		}
		return result;
	}
	
	public Diary read(int diaryNo){
		Diary diary = diaryDao.select(diaryNo);
		return diary;
	}
	
	public DiaryPage makePage(int currentPage, String id){
		final int COUNT_PER_PAGE=3;
		int totalDiaryCount = diaryDao.selectDiaryCount();
		
		System.out.println("total:"+totalDiaryCount);
		
		if(totalDiaryCount==0)
			return new DiaryPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		
		List<Diary> diaryList = 
				diaryDao.selectDiaryList(startRow, endRow, id);
		
		int totalPage = totalDiaryCount/COUNT_PER_PAGE;
		if(totalDiaryCount%COUNT_PER_PAGE !=0)
			totalPage++;
		
		int startPage = (currentPage-1)/5*5+1;
		int endPage = startPage+4;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new DiaryPage(diaryList, startPage, endPage, currentPage, totalPage);	
	}		
	
}
