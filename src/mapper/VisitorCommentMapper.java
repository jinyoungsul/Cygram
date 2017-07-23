package mapper;

import java.util.List;

import vo.VisitorComment;

public interface VisitorCommentMapper {
	public int insertVisitorComment(VisitorComment visitorComment);
	public int updateVisitorComment(VisitorComment visitorComment);	
	public int deleteVisitorComment(int visitorCommentNo);
	public List<VisitorComment> selectVisitorComment(int visitorNo);
}
