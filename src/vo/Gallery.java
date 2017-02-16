package vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Gallery {
	private int galleryNo;
	private String title;
	private String id;
	private Date writeDate;
	private String content;
	private int authorityCode;
	private List<GalleryImg> galleryImgList; 
	
	//----------------------------------------------//
	public Gallery(){}
	public Gallery(int galleryNo, String title, String id, Date writeDate, String content, int authorityCode,
			List<GalleryImg> galleryImgList, List<MultipartFile> photoList) {
		super();
		this.galleryNo = galleryNo;
		this.title = title;
		this.id = id;
		this.writeDate = writeDate;
		this.content = content;
		this.authorityCode = authorityCode;
		this.galleryImgList = galleryImgList;
		this.photoList = photoList;
	}
	
	//-------------------------------------------------------------/
	
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
	public int getAuthorityCode() {
		return authorityCode;
	}
	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}
	public List<GalleryImg> getGalleryImgList() {
		return galleryImgList;
	}
	public void setGalleryImgList(List<GalleryImg> galleryImgList) {
		this.galleryImgList = galleryImgList;
	}

	@Override
	public String toString() {
		return "Gallery [galleryNo=" + galleryNo + ", title=" + title + ", id=" + id + ", writeDate=" + writeDate
				+ ", content=" + content + ", authorityCode=" + authorityCode + ", galleryImgList=" + galleryImgList
				+ ", photoList=" + photoList + "]";
	}

	//--------------------------------------------------------------------------//

	private List<MultipartFile> photoList;

	public List<MultipartFile> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<MultipartFile> photoList) {
		this.photoList = photoList;
	}	
}
