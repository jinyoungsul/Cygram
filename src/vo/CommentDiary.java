package vo;

import java.util.Date;

public class CommentDiary {
	private int commentDiaryNo;
	private int diaryNo;
	private String content;
	private String myId;
	private String friendId;
	private Date writeDate;
	private Member member;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getCommentDiaryNo() {
		return commentDiaryNo;
	}
	public void setCommentDiaryNo(int commentDiaryNo) {
		this.commentDiaryNo = commentDiaryNo;
	}
	public int getDiaryNo() {
		return diaryNo;
	}
	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "CommentDiary [commentDiaryNo=" + commentDiaryNo + ", diaryNo=" + diaryNo + ", content=" + content
				+ ", myId=" + myId + ", friendId=" + friendId + ", writeDate=" + writeDate + "]";
	}
	
}
