package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.CommentDiaryMapper;
import mapper.DiaryMapper;
import vo.CommentDiary;

@Component
public class CommentDiaryDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	//-----------------------------------------------//
	
	public int insertCommentDiary(CommentDiary commentDiary){
		CommentDiaryMapper mapper = session.getMapper(CommentDiaryMapper.class);
		System.out.println("댓글 등록 :"+commentDiary);
		return mapper.insertCommentDiary(commentDiary);
	}
	
	public List<CommentDiary> selectCommentDiary(int diaryNo){
		CommentDiaryMapper mapper = session.getMapper(CommentDiaryMapper.class);
		return mapper.selectCommentDiary(diaryNo);	
	}
}
