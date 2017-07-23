package vo;

import java.util.Date;

public class VisitorComment {
	private int visitorCommentNo;
	private int visitorNo;
	private String content;
	private String myId;
	private Date writeDate;
	private Member member;
	public int getVisitorCommentNo() {
		return visitorCommentNo;
	}
	public void setVisitorCommentNo(int visitorCommentNo) {
		this.visitorCommentNo = visitorCommentNo;
	}
	public int getVisitorNo() {
		return visitorNo;
	}
	public void setVisitorNo(int visitorNo) {
		this.visitorNo = visitorNo;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
