package vo;

import java.util.Date;

public class FriendComment {
	private int friendCommentNo;
	private String myId;
	private String friendId;
	private String content;
	private Date writeDate;
	private Friend friend;
	public int getFriendCommentNo() {
		return friendCommentNo;
	}
	public void setFriendCommentNo(int friendCommentNo) {
		this.friendCommentNo = friendCommentNo;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	@Override
	public String toString() {
		return "FriendComment [friendCommentNo=" + friendCommentNo + ", myId=" + myId + ", friendId=" + friendId
				+ ", content=" + content + ", writeDate=" + writeDate + ", friend=" + friend + "]";
	}
	
	
}
