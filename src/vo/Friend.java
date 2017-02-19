package vo;

public class Friend {
	private int friendNo;
	private String myId;
	private String myNickname;
	private String friendId;
	private String friendNickname;
	private String action;
	private String accept;
	private MiniHomepage miniHomepage;
	public int getFriendNo() {
		return friendNo;
	}
	public void setFriendNo(int friendNo) {
		this.friendNo = friendNo;
	}
	public String getMyId() {
		return myId;
	}
	public void setMyId(String myId) {
		this.myId = myId;
	}
	public String getMyNickname() {
		return myNickname;
	}
	public void setMyNickname(String myNickname) {
		this.myNickname = myNickname;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendNickname() {
		return friendNickname;
	}
	public void setFriendNickname(String friendNickname) {
		this.friendNickname = friendNickname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	public MiniHomepage getMiniHomepage() {
		return miniHomepage;
	}
	public void setMiniHomepage(MiniHomepage miniHomepage) {
		this.miniHomepage = miniHomepage;
	}
	@Override
	public String toString() {
		return "Friend [friendNo=" + friendNo + ", myId=" + myId + ", myNickname=" + myNickname + ", friendId="
				+ friendId + ", friendNickname=" + friendNickname + ", action=" + action + ", accept=" + accept
				+ ", miniHomepage=" + miniHomepage + "]";
	}
	
}
