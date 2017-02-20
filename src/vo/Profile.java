package vo;

import java.util.Date;

public class Profile {
	private String id;
	private String title;
	private String content;
	private Date writeDate;
	
	//-----------------------------------------//
	
	public Profile(){}
	public Profile(String id, String title, String content, Date writeDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
	}
	
	//-----------------------------------------//
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

}
