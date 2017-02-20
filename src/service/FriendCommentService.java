package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FriendCommentDao;
import vo.FriendComment;

@Component
public class FriendCommentService {
	@Autowired
	private FriendCommentDao friendCommentDao;
	
	public int insertFriendsComment(FriendComment friendComment) {
		return friendCommentDao.insertFriendsComment(friendComment);
	}

	public List<FriendComment> selectFriendsComment(String friendId) {
		return friendCommentDao.selectFriendsComment(friendId);
	}

}
