package service;

import java.util.List;

import org.springframework.stereotype.Component;

import repository.GalleryCommentDao;
import vo.GalleryComment;

@Component
public class GalleryCommentService {
	private GalleryCommentDao galleryCommentDao;
	public void setGalleryCommentDao(GalleryCommentDao galleryCommentDao) {
		this.galleryCommentDao = galleryCommentDao;
	}
	
	//---------------------------------------//
	
	public int insertGalleryComment(GalleryComment galleryComment) {
		return galleryCommentDao.insertGalleryComment(galleryComment);
	}
	
	public List<GalleryComment> selectGalleryComment(int galleryNo){
		return galleryCommentDao.selectGalleryComment(galleryNo);
	}

	
}
