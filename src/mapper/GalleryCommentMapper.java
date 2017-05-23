package mapper;

import java.util.List;

import vo.GalleryComment;

public interface GalleryCommentMapper {
	public int insertGalleryComment(GalleryComment galleryComment);
	public int updateGalleryComment(GalleryComment galleryComment);	
	public int deleteGalleryComment(int galleryCommentNo);
	public List<GalleryComment> selectGalleryComment(int galleryNo);
}
