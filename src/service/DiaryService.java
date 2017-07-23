package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.CommentDiaryDao;
import repository.DiaryDao;
import repository.FriendsDao;
import vo.CommentDiary;
import vo.Diary;
import vo.DiaryPage;

@Component
public class DiaryService {
	@Autowired
	private DiaryDao diaryDao;
	public void setDiaryDao(DiaryDao diaryDao){
		this.diaryDao=diaryDao;
	}
	@Autowired
	private CommentDiaryDao commentDiaryDao;
	public void setCommentDiaryDao(CommentDiaryDao commentDiaryDao) {
		this.commentDiaryDao = commentDiaryDao;
	}
	@Autowired
	private FriendsDao friendsDao;
	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
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
	
	public int modify(Diary diary){
		diary.setWriteDate(new Date());
		int result=0;
		result=diaryDao.update(diary); 
		return result;
	}
	
	public int delete(int diaryNo){
		int result=0;
		result=diaryDao.delete(diaryNo);
		return result;
	}
	
	public Diary read(int diaryNo){
		Diary diary = diaryDao.select(diaryNo);
		return diary;
	}
	
	public DiaryPage makePage(int currentPage, String id, String loginId){
		final int COUNT_PER_PAGE=3;
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		int totalDiaryCount;
		List<Diary> diaryList;
		
		if(loginId.equals(id)){
			totalDiaryCount = diaryDao.selectDiaryCount(id);
			diaryList = diaryDao.selectDiaryList(startRow, endRow, id);
		}else if (friendsDao.isOkFriends(loginId, id) != null) {
			totalDiaryCount = diaryDao.selectDiaryFriendCount(id);
			diaryList = diaryDao.selectDiaryFriendList(startRow, endRow, id);
		}else{
			totalDiaryCount = diaryDao.selectDiaryPrivateCount(id);
			diaryList = diaryDao.selectDiaryPrivateList(startRow, endRow, id);
		}
	
		if(totalDiaryCount==0)
			return new DiaryPage();

		for(Diary diary : diaryList){
			int diaryNo = diary.getDiaryNo();
			List<CommentDiary> commentDiaryList = commentDiaryDao.selectCommentDiary(diaryNo);
			diary.setCommentDiaryList(commentDiaryList);
		}
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
