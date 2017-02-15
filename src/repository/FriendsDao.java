package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FriendMapper;
import mapper.MemberMapper;
import vo.Friend;

@Component
public class FriendsDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
/////////////////////////////////////////////////////////
	public List<Friend> selectSendFriendsList(String id){
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.selectSendFriendsList(id);
	}
	public List<Friend> selectReceiveFriendsList(String id) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.selectReceiveFriendsList(id);
	}
	public int insertFriends(Friend friend) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.insertFriends(friend);
	}
}
