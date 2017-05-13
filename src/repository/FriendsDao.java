package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FriendMapper;
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
	public Friend checkFriends(String myId, String friendId) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		Map<String, String> map = new HashMap<>();
		map.put("myId", myId);
		map.put("friendId", friendId);
		return mapper.checkFriends(map);
	}
	public Friend isOkFriends(String myId, String friendId) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		Map<String, String> map = new HashMap<>();
		map.put("myId", myId);
		map.put("friendId", friendId);
		return mapper.isOkFriends(map);
	}
	public Friend selectFriends(int friendNo) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.selectFriends(friendNo);
	}
	public int cancelFriends(int friendNo) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.cancelFriends(friendNo);
	}
	public int acceptFriends(int friendNo) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.acceptFriends(friendNo);
	}
	public List<Friend> selectAcceptFriends(String id) {
		FriendMapper mapper = session.getMapper(FriendMapper.class);
		return mapper.selectAcceptFriends(id);
	}
}
