package vo;

import org.springframework.web.multipart.MultipartFile;

public class MiniHomepage {
	private String id;
	private int today;
	private int total;
	private String title;
	private String introduce;
	private String minihomepage_img_path;
	private Member member;
	private MultipartFile minihomepage_img;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getTotal() {
		return total;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMinihomepage_img_path() {
		return minihomepage_img_path;
	}
	public void setMinihomepage_img_path(String minihomepage_img_path) {
		this.minihomepage_img_path = minihomepage_img_path;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public MultipartFile getMinihomepage_img() {
		return minihomepage_img;
	}
	public void setMinihomepage_img(MultipartFile minihomepage_img) {
		this.minihomepage_img = minihomepage_img;
	}
	@Override
	public String toString() {
		return "MiniHomepage [id=" + id + ", today=" + today + ", total=" + total + ", title=" + title + ", introduce="
				+ introduce + ", minihomepage_img_path=" + minihomepage_img_path + ", member=" + member
				+ ", minihomepage_img=" + minihomepage_img + "]";
	}
	
}
