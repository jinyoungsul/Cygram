package vo;

public class Member {
	private int memberNum;
	private String id;
	private String password;
	private String email;
	private String phone;
////////////////////////////////////////////////////
	public Member(){}
	
	public Member(String id, String password, String email, String phone) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	public Member(int memberNum, String id, String password, String email, String phone) {
		this.memberNum = memberNum;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
///////////////////////////////////////////////////////	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
///////////////////////////////////////////////////////	
	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + "]";
	}
}
