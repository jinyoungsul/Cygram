package vo;

public class GalleryImg {
	private int galleryNo;
	private int galleryImgNo;
	private String originalFileName;
	private String storedFileName;
	private String galleryPath;
	private String del;
	
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
	
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "GalleryImg [galleryNo=" + galleryNo + ", galleryImgNo=" + galleryImgNo + ", originalFileName="
				+ originalFileName + ", storedFileName=" + storedFileName + ", galleryPath=" + galleryPath + ", del="
				+ del + "]";
	}
	
	
	
}
