package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MusicMapper;
import vo.Music;

@Component
public class MusicDao {
	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	public void uploadMusic(Music music) {
		MusicMapper mapper = session.getMapper(MusicMapper.class);
		mapper.uploadMusic(music);
	}

	public List<Music> selectMusicList() {
		MusicMapper mapper = session.getMapper(MusicMapper.class);
		return mapper.selectMusicList();
	}

	public Music selectMusic(int musicNo) {
		MusicMapper mapper = session.getMapper(MusicMapper.class);
		return mapper.selectMusic(musicNo);
	}

	public void buyMusic(int musicNo, String loginId) {
		MusicMapper mapper = session.getMapper(MusicMapper.class);
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("musicNo", musicNo);
		paramMap.put("loginId", loginId);
		mapper.buyMusic(paramMap);
	}

	public List<Music> selectBgmList(String id) {
		MusicMapper mapper = session.getMapper(MusicMapper.class);
		return mapper.selectBgmList(id);
	}

}
