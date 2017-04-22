package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import repository.MusicDao;
import vo.Music;

@Component
public class MusicService {
	@Autowired
	private MusicDao musicDao;
	
	public void setMusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
	}


	public void uploadMusic(Music music) {
		musicDao.uploadMusic(music);		
	}


	public List<Music> selectMusicList() {
		return musicDao.selectMusicList();
	}


	public Music selectMusic(int musicNo) {
		return musicDao.selectMusic(musicNo);
	}


	public void buyMusic(int musicNo, String loginId) {
		musicDao.buyMusic(musicNo,loginId);
	}
	public List<Music> bgmList(String id){
		return musicDao.selectBgmList(id);
	}
}
