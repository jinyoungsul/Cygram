package vo;

import java.util.Date;

public class Visitor {
	private int visitorNo;
	private String id;
	private String friendId;
	private String content;
	private Date writeDate;
	private int authorityCode;
	
	public Visitor(){}
	public Visitor(int visitorNo, String id, String friendId, String content, Date writeDate, int authorityCode) {
		super();
		this.visitorNo = visitorNo;
		this.id = id;
		this.friendId = friendId;
		this.content = content;
		this.writeDate = writeDate;
		this.authorityCode = authorityCode;
	}
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
}
