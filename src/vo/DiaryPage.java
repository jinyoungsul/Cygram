package vo;

import java.util.List;

public class DiaryPage {
	private List<Diary> DiaryList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	
	public DiaryPage(){}
	public DiaryPage(List<Diary> diaryList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		DiaryList = diaryList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	
	public List<Diary> getDiaryList() {
		return DiaryList;
	}
	public void setDiaryList(List<Diary> diaryList) {
		DiaryList = diaryList;
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
	@Override
	public String toString() {
		return "DiaryPage [DiaryList=" + DiaryList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", currentPage=" + currentPage + ", totalPage=" + totalPage + "]";
	}
	
	
}