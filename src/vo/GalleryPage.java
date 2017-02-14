package vo;

import java.util.List;

public class GalleryPage {
	private List<Gallery> galleryList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	//-------------------------------------
	public GalleryPage(){}
	public GalleryPage(List<Gallery> galleryList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		this.galleryList = galleryList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	//-------------------------------------
	public List<Gallery> getGalleryList() {
		return galleryList;
	}
	public void setGalleryList(List<Gallery> galleryList) {
		this.galleryList = galleryList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
