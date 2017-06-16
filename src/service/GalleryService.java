package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FriendsDao;
import repository.GalleryDao;
import vo.Gallery;
import vo.GalleryImg;
import vo.GalleryPage;

@Component
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	public void setGalleryDao(GalleryDao galleryDao){
		this.galleryDao=galleryDao;
	}
	@Autowired
	private FriendsDao friendsDao;
	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}
	//-----------------------------------------------//
	
	public int write(Gallery gallery, List<GalleryImg> galleryImgList){
		gallery.setWriteDate(new Date()); 
		int result = galleryDao.insert(gallery);
		
		if(result>0){
			for(GalleryImg galleryImg : galleryImgList){
				galleryImg.setGalleryNo(gallery.getGalleryNo());
				galleryDao.insertImg(galleryImg);
			}
		}
		System.out.println("service write file:");
		return gallery.getGalleryNo();
	}
	
	public Gallery read(int galleryNo){
		Gallery gallery = galleryDao.select(galleryNo);
		return gallery;
	}
	
	public GalleryPage makePage(int currentPage,String id,String loginId){
		final int COUNT_PER_PAGE=3;
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		int totalGalleryCount;		
		List<Gallery> galleryList;  
		
		if(loginId.equals(id)){
			totalGalleryCount = galleryDao.selectGalleryCount(id);
			galleryList = galleryDao.selectGalleryList(startRow, endRow, id);	
		}else if (friendsDao.isOkFriends(id, loginId) != null) {
			totalGalleryCount = galleryDao.selectFriendCount(id);
			galleryList = galleryDao.selectGalleryFriendList(startRow, endRow, id);
		}else{
			totalGalleryCount = galleryDao.selectPrivateCount(id);
			galleryList = galleryDao.selectGalleryPrivateList(startRow, endRow, id);
		}
		
		if(totalGalleryCount==0)
			return new GalleryPage();
				
		for(Gallery g: galleryList){
			int galleryNo = g.getGalleryNo();
			List<GalleryImg> galleryImgList = galleryDao.selectImgList(galleryNo);
			g.setGalleryImgList(galleryImgList);
			System.out.println(g);
		}
		
		int totalPage = totalGalleryCount/COUNT_PER_PAGE;
		if(totalGalleryCount%COUNT_PER_PAGE !=0)
			totalPage++;
		
		int startPage = (currentPage-1)/5*5+1;
		int endPage = startPage+4;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new GalleryPage(galleryList, startPage, endPage, currentPage, totalPage);	
	}
	
	public int modify(Gallery gallery, List<GalleryImg> galleryImgList){
		int result=0;
		gallery.setWriteDate(new Date());
		result = galleryDao.update(gallery);
		if(result>0){
			for(GalleryImg galleryImg : galleryImgList){
			galleryDao.updateImg(galleryImg);
			}
		}
		return result;
	}
}