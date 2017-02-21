package vo;

import java.util.List;

public class VisitorPage {
	private List<Visitor> VisitorList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	
	public VisitorPage(){}
	public VisitorPage(List<Visitor> visitorList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		VisitorList = visitorList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	public List<Visitor> getVisitorList() {
		return VisitorList;
	}
	public void setVisitorList(List<Visitor> visitorList) {
		VisitorList = visitorList;
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