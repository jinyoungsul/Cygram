package service;

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

}
