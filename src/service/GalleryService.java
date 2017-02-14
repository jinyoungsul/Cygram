package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.GalleryDao;
import vo.Gallery;
import vo.GalleryPage;

@Component
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;
	public void setGalleryDao(GalleryDao galleryDao){
		this.galleryDao=galleryDao;
	}
	//-----------------------------------------------//
	
	public int write(Gallery gallery){
		int result = 0;
		
		gallery.setWriteDate(new Date());
		if(galleryDao.insert(gallery)>0)
			result = gallery.getGalleryNo();
		return result;
	}
	
	public Gallery read(int galleryNo){
		Gallery gallery = galleryDao.select(galleryNo);
		return gallery;
	}
	
	public GalleryPage makePage(int currentPage){
		final int COUNT_PER_PAGE=3;
		int totalGalleryCount = galleryDao.selectCount();
		
		if(totalGalleryCount==0)
			return new GalleryPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		List<Gallery> galleryList = 
				galleryDao.selectList(startRow, endRow);
		
		int totalPage = totalGalleryCount/COUNT_PER_PAGE;
		if(totalGalleryCount%COUNT_PER_PAGE !=0)
			totalPage++;
		
		int startPage = (currentPage-1)/5*5+1;
		int endPage = startPage+4;
		if(endPage>totalPage)
			endPage = totalPage;
		
		return new GalleryPage(galleryList, startPage, endPage, currentPage, totalPage);	
	}		
}