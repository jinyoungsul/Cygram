package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.CommentDiaryMapper;
import mapper.GalleryCommentMapper;
import vo.CommentDiary;
import vo.GalleryComment;
@Component
public class GalleryCommentDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//----------------------------//
	
	public int insertGalleryComment(GalleryComment galleryComment){
		GalleryCommentMapper mapper = session.getMapper(GalleryCommentMapper.class);
		return mapper.insertGalleryComment(galleryComment);
	}
	
	public List<GalleryComment> selectGalleryComment(int galleryNo){
		GalleryCommentMapper mapper = session.getMapper(GalleryCommentMapper.class);
		return mapper.selectGalleryComment(galleryNo);	
	}
}
