package mapper;

import java.util.List;
import java.util.Map;

import vo.Music;

public interface MusicMapper {
	public void uploadMusic(Music music);
	public List<Music> selectMusicList();
	public Music selectMusic(int musicNo);
	public void buyMusic(Map<String, Object> paramMap);
	public List<Music> selectBgmList(String id);
}
