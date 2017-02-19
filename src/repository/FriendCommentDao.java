package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FriendCommentMapper;
import vo.FriendComment;

@Component
public class FriendCommentDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
/////////////////////////////////////////////////////////

	public int insertFriendsComment(FriendComment friendComment) {
		FriendCommentMapper mapper = session.getMapper(FriendCommentMapper.class);
		return mapper.insertFriendsComment(friendComment);
	}
	public List<FriendComment> selectFriendsComment(String id){
		FriendCommentMapper mapper = session.getMapper(FriendCommentMapper.class);
		return mapper.selectFriendsComment(id);
	}
}
