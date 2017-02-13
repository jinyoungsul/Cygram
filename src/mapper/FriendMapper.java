package mapper;

import java.util.List;

import vo.Friend;

public interface FriendMapper {
	public List<Friend> selectSendFriendsList(String id);
	public List<Friend> selectReceiveFriendsList(String id);
}
