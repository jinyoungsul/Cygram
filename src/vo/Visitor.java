package vo;

import java.util.Date;
import java.util.List;

public class Visitor {
	private int visitorNo;
	private String id;
	private String friendId;
	private String content;
	private Date writeDate;
	private int authorityCode;
	private List<VisitorComment> visitorCommentList;
	
	public int getVisitorNo() {
		return visitorNo;
	}
	public void setVisitorNo(int visitorNo) {
		this.visitorNo = visitorNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}
	public List<VisitorComment> getVisitorCommentList() {
		return visitorCommentList;
	}
	public void setVisitorCommentList(List<VisitorComment> visitorCommentList) {
		this.visitorCommentList = visitorCommentList;
	}
	
	
}
