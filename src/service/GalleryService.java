package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
	public GalleryPage makePage(int currentPage,String id){
		final int COUNT_PER_PAGE=3;
		int totalGalleryCount = galleryDao.selectCount();
		
		System.out.println("total:"+totalGalleryCount);
		
		if(totalGalleryCount==0)
			return new GalleryPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		List<Gallery> galleryList = 
				galleryDao.selectList(startRow, endRow,id);
		
		System.out.println("start:"+startRow+"/end:"+endRow);
		System.out.println("list size:"+galleryList.size());
		
		System.out.println("사진첩리스트 확인");
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
}