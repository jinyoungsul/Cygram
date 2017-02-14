package vo;

import java.util.Date;

public class Gallery {
	private int galleryNo;
	private String title;
	private String id;
	private Date writeDate;
	private String content;
	private String galleryPath;
	private int authorityCode;
	//----------------------------------------------//
	
	public Gallery(){}
	public Gallery(String title, String id, String content, String galleryPath) {
		super();
		this.title = title;
		this.id = id;
		this.content = content;
		this.galleryPath = galleryPath;
	}
	public Gallery(String title, String id, String content, String galleryPath, int authorityCode) {
		super();
		this.title = title;
		this.id = id;
		this.content = content;
		this.galleryPath = galleryPath;
		this.authorityCode = authorityCode;
	}
	public Gallery(int galleryNo, String title, String id, Date writeDate, String content, String galleryPath,
			int authorityCode) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.id = id;
		this.writeDate = writeDate;
		this.content = content;
		this.galleryPath = galleryPath;
		this.authorityCode = authorityCode;
	}
	//----------------------------------------------//
	
	public int getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(int galleryNo) {
		this.galleryNo = galleryNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGalleryPath() {
		return galleryPath;
	}
	public void setGalleryPath(String galleryPath) {
		this.galleryPath = galleryPath;
	}
	public int getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}
}
