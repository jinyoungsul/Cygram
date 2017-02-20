package mapper;

import java.util.List;

import vo.FriendComment;

public interface FriendCommentMapper {
	public int insertFriendsComment(FriendComment friendComment);
	public List<FriendComment> selectFriendsComment(String id);
}
