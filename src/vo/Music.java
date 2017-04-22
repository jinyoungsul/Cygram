package vo;

import org.springframework.web.multipart.MultipartFile;

public class Music {
	private int musicNo;
	private String musicName;
	private String artist;
	private MultipartFile albumImg;
	private MultipartFile musicFile;
	private String albumImgPath;
	private String musicFilePath;
	
	public int getMusicNo() {
		return musicNo;
	}
	public void setMusicNo(int musicNo) {
		this.musicNo = musicNo;
	}
	public String getMusicName() {
		return musicName;
	}
	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public MultipartFile getAlbumImg() {
		return albumImg;
	}
	public void setAlbumImg(MultipartFile albumImg) {
		this.albumImg = albumImg;
	}
	public MultipartFile getMusicFile() {
		return musicFile;
	}
	public void setMusicFile(MultipartFile musicFile) {
		this.musicFile = musicFile;
	}
	
	public String getAlbumImgPath() {
		return albumImgPath;
	}
	public void setAlbumImgPath(String albumImgPath) {
		this.albumImgPath = albumImgPath;
	}
	public String getMusicFilePath() {
		return musicFilePath;
	}
	public void setMusicFilePath(String musicFilePath) {
		this.musicFilePath = musicFilePath;
	}
	@Override
	public String toString() {
		return "Music [musicNo=" + musicNo + ", musicName=" + musicName + ", artist=" + artist + ", albumImg="
				+ albumImg + ", musicFile=" + musicFile + ", albumImgPath=" + albumImgPath + ", musicFilePath="
				+ musicFilePath + "]";
	}
	
	
}
