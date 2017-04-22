package vo;

import java.util.Date;
import java.util.List;

public class Diary {
	private int diaryNo;
	private String id;
	private String title;
	private String content;
	private Date writeDate;
	private int authorityCode;
	private List<CommentDiary> commentDiaryList;
		
	public List<CommentDiary> getCommentDiaryList() {
		return commentDiaryList;
	}
	public void setCommentDiaryList(List<CommentDiary> commentDiaryList) {
		this.commentDiaryList = commentDiaryList;
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
	
	@Override
	public String toString() {
		return "Diary [diaryNo=" + diaryNo + ", id=" + id + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", authorityCode=" + authorityCode + ", commentDiaryList=" + commentDiaryList + "]";
	}
	
	
}
