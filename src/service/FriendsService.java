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
	
}
