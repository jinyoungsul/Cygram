package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FriendsDao;
import vo.Friend;

@Component
public class FriendsService {
	@Autowired
	private FriendsDao friendsDao;

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}

	public List<Friend> selectSendFriendsList(String id) {
		return friendsDao.selectSendFriendsList(id);
	}
	public List<Friend> selectReceiveFriendsList(String id){
		return friendsDao.selectReceiveFriendsList(id);
	}

	public int insertFriends(Friend friend) {
		return friendsDao.insertFriends(friend);
	}

	public Friend checkFriend(String myId,String friendId) {
		return friendsDao.checkFriends(myId,friendId);
	}

	public Friend selectFriends(int friendNo) {
		return friendsDao.selectFriends(friendNo);
	}

	public int cancelFriends(int friendNo) {
		return friendsDao.cancelFriends(friendNo);
	}

	public int acceptFriends(int friendNo) {
		return friendsDao.acceptFriends(friendNo);
	}

	public List<Friend> selectAcceptFriends(String id) {
		return friendsDao.selectAcceptFriends(id);
	}
	
}
