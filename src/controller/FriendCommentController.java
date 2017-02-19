package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.FriendCommentService;
import vo.FriendComment;

@Controller
public class FriendCommentController {
	@Autowired
	private FriendCommentService friendCommentService;

	public void setFriendCommentService(FriendCommentService friendCommentService) {
		this.friendCommentService = friendCommentService;
	}
	
	@RequestMapping(value="/friendsCommentUpdate.do")
	public @ResponseBody List<FriendComment> friendsCommentUpdate(String myId,String friendId,String content){
		FriendComment friendComment = new FriendComment();
		friendComment.setMyId(myId);
		friendComment.setFriendId(friendId);
		friendComment.setContent(content);
		System.out.println(friendComment);
		friendCommentService.insertFriendsComment(friendComment);
		List<FriendComment> friendCommentList = friendCommentService.selectFriendsComment(friendId);
		return friendCommentList;
	}
	
}
