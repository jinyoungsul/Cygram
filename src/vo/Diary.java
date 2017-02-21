package vo;

import java.util.Date;

public class Diary {
	private int diaryNo;
	private String id;
	private String title;
	private String content;
	private Date writeDate;
	private int authorityCode;
	
	
	public Diary(){};
	public Diary(int diaryNo, String id, String title, String content, Date writeDate, int authorityCode) {
		super();
		this.diaryNo = diaryNo;
		this.id = id;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.authorityCode = authorityCode;
	}
	
	public int getDiaryNo() {
		return diaryNo;
	}
	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}
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
	public int getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}
	
}
