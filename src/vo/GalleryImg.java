package vo;

public class GalleryImg {
	private int galleryNo;
	private int galleryImgNo;
	private String galleryPath;
	
	//-----------------------------------------------//
	
	public int getGalleryNo() {
		return galleryNo;
	}
	public void setGalleryNo(int galleryNo) {
		this.galleryNo = galleryNo;
	}
	public int getGalleryImgNo() {
		return galleryImgNo;
	}
	public void setGalleryImgNo(int galleryImgNo) {
		this.galleryImgNo = galleryImgNo;
	}
	public String getGalleryPath() {
		return galleryPath;
	}
	public void setGalleryPath(String galleryPath) {
		this.galleryPath = galleryPath;
	}
	@Override
	public String toString() {
		return "GalleryImg [galleryNo=" + galleryNo + ", galleryImgNo=" + galleryImgNo + ", galleryPath=" + galleryPath
				+ "]";
	}
	
	
	
}
