package mapper;

import java.util.List;
import java.util.Map;

import vo.Friend;

public interface FriendMapper {
	public List<Friend> selectSendFriendsList(String id);
	public List<Friend> selectReceiveFriendsList(String id);
	public int insertFriends(Friend friend);
	public Friend checkFriends(Map<String,String> map);
	public Friend selectFriends(int friendNo);
	public int cancelFriends(int friendNo);
	public int acceptFriends(int friendNo);
	public List<Friend> selectAcceptFriends(String id);
}
