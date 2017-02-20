package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody List<FriendComment> friendsCommentUpdate(String myId,String friendId,@RequestParam(value="content",defaultValue="")String content){
		FriendComment friendComment = new FriendComment();
		friendComment.setMyId(myId);
		friendComment.setFriendId(friendId);
		friendComment.setContent(content);
		System.out.println(friendComment);
		if(content.length()>0)
			friendCommentService.insertFriendsComment(friendComment);
		List<FriendComment> friendCommentList = friendCommentService.selectFriendsComment(friendId);
		for(FriendComment friendComment2 : friendCommentList){
			System.out.println(friendComment2);
		}
		return friendCommentList;
	}
	
}
