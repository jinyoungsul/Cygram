package mapper;

import java.util.List;

import vo.CommentDiary;

public interface CommentDiaryMapper {
	public int insertCommentDiary(CommentDiary commentDiary);
	public int updateCommentDiary(CommentDiary commentDiary);	
	public int deleteCommentDiary(int commentDiaryNo);
	public List<CommentDiary> selectCommentDiary(String id);
	public List<CommentDiary> selectCommentList(int diaryNo);
}
