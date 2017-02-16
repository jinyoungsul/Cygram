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
	
	public int write(Gallery gallery, GalleryImg galleryImg){
		int result = 0;
		
		gallery.setWriteDate(new Date()); 
		if(galleryDao.insert(gallery)>0)
			galleryDao.insertImg(galleryImg);
			result = gallery.getGalleryNo();
		
		System.out.println("service write file:");
		return result;
	}
	
	public Gallery read(int galleryNo){
		Gallery gallery = galleryDao.select(galleryNo);
		return gallery;
	}
	
	public GalleryPage makePage(int currentPage){
		final int COUNT_PER_PAGE=3;
		int totalGalleryCount = galleryDao.selectCount();
		
		System.out.println("total:"+totalGalleryCount);
		
		if(totalGalleryCount==0)
			return new GalleryPage();
		
		int startRow = ((currentPage-1)*COUNT_PER_PAGE)+1;
		int endRow = startRow +2;
		List<Gallery> galleryList = 
				galleryDao.selectList(startRow, endRow);
		
		System.out.println("start:"+startRow+"/end:"+endRow);
		System.out.println("list size:"+galleryList.size());
		
		
		for(Gallery g: galleryList){
			System.out.println("--글시작");
			System.out.println("\t"+g.toString());
			for(GalleryImg img: g.getGalleryImgList()){
				System.out.println("\t\t"+img.toString());
			}
			System.out.println("--글끝");
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