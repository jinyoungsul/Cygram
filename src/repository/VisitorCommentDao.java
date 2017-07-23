package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.VisitorCommentMapper;
import vo.VisitorComment;
@Component
public class VisitorCommentDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	//----------------------------//
	
	public int insertVisitorComment(VisitorComment visitorComment){
		VisitorCommentMapper mapper = session.getMapper(VisitorCommentMapper.class);
		return mapper.insertVisitorComment(visitorComment);
	}
	
	public List<VisitorComment> selectVisitorComment(int visitorNo){
		VisitorCommentMapper mapper = session.getMapper(VisitorCommentMapper.class);
		return mapper.selectVisitorComment(visitorNo);	
	}

	public int deleteVisitorComment(int visitorCommentNo) {
		VisitorCommentMapper mapper = session.getMapper(VisitorCommentMapper.class);
		return mapper.deleteVisitorComment(visitorCommentNo);	
	}
}
