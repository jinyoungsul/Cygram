package vo;

import java.util.Date;

public class GalleryComment {
	private int galleryCommentNo;
	private int galleryNo;
	private String content;
	private String myId;
	private Date writeDate;
	private Member member;
	
	public int getGalleryCommentNo() {
		return galleryCommentNo;
	}
	public void setGalleryCommentNo(int galleryCommentNo) {
		this.galleryCommentNo = galleryCommentNo;
	}
	public int getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(int galleryNo) {
		this.galleryNo = galleryNo;
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
	@Override
	public String toString() {
		return "GalleryComment [galleryCommentNo=" + galleryCommentNo + ", galleryNo=" + galleryNo + ", content="
				+ content + ", myId=" + myId + ", writeDate=" + writeDate + ", member=" + member + "]";
	}
	
}
