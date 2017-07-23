package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.DiaryDao;
import repository.FriendsDao;
import repository.GalleryDao;
import repository.MiniHomepageDao;
import vo.MiniHomepage;

@Component
public class MiniHomepageService {
	@Autowired
	private MiniHomepageDao dao;
	@Autowired
	private GalleryDao galleryDao;
	@Autowired
	private FriendsDao friendsDao;
	@Autowired
	private DiaryDao diaryDao;
	
	public void setDao(MiniHomepageDao dao) {
		this.dao = dao;
	}
	public void setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}
	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}
	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}
	public int createMiniHomepage(String id){
		return dao.createMiniHomepage(id);
	}
	public MiniHomepage selectMiniHomepage(String id){
		return dao.selectMiniHomepage(id);
	}

	public List<MiniHomepage> selectMiniHomepageList(String keyword,int startRow,int count) {
		return dao.selectMiniHomepageList(keyword,startRow,count);
	}

	public int increaseTodayTotal(String id) {
		 return dao.increaseTodayTotal(id);
		
	}

	public int titleUpdate(String id, String title) {
		return dao.titleUpdate(id,title);
	}

	public int introduceImgUpdate(MiniHomepage miniHomepage) {
		return dao.introduceImgUpdate(miniHomepage);
	}
	public Map<String,Object> minihomepageHome(String id,String loginId){
		int totalGalleryCount,newGalleryCount;
		int totalDiaryCount,newDiaryCount;
		Map<String,Object> map = new HashMap<String,Object>();
		if(id.equals(loginId)){
			totalGalleryCount = galleryDao.selectGalleryCount(id);
			newGalleryCount = galleryDao.selectNewGalleryCount(id);
			totalDiaryCount = diaryDao.selectDiaryCount(id);
			newDiaryCount = diaryDao.selectNewDiaryCount(id);
			map.put("totalGalleryCount", totalGalleryCount);
			map.put("newGalleryCount", newGalleryCount);
			map.put("totalDiaryCount", totalDiaryCount);
			map.put("newDiaryCount", newDiaryCount);
		} else if (friendsDao.isOkFriends(id, loginId) != null) {
			totalGalleryCount = galleryDao.selectFriendCount(id);
			totalDiaryCount = diaryDao.selectDiaryFriendCount(id);
			newGalleryCount = galleryDao.selectNewGalleryFriendCount(id);
			newDiaryCount = diaryDao.selectNewDiaryFriendCount(id);
			map.put("totalGalleryCount", totalGalleryCount);
			map.put("newGalleryCount", newGalleryCount);
			map.put("totalDiaryCount", totalDiaryCount);
			map.put("newDiaryCount", newDiaryCount);
		} else {
			totalGalleryCount = galleryDao.selectPrivateCount(id);
			totalDiaryCount = diaryDao.selectDiaryPrivateCount(id);
			newGalleryCount = galleryDao.selectNewGalleryPrivateCount(id);
			newDiaryCount = diaryDao.selectNewDiaryPrivateCount(id);
			map.put("totalGalleryCount", totalGalleryCount);
			map.put("newGalleryCount", newGalleryCount);
			map.put("totalDiaryCount", totalDiaryCount);
			map.put("newDiaryCount", newDiaryCount);
		}
		return map;
	}
}
