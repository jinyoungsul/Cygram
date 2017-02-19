package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.MiniHomepageMapper;
import vo.MiniHomepage;

@Component
public class MiniHomepageDao {
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int createMiniHomepage(String id){
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		return mapper.createMiniHomepage(id);
	}

	public MiniHomepage selectMiniHomepage(String id) {
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		return mapper.selectMiniHomepage(id);
	}

	public List<MiniHomepage> selectMiniHomepageList(String keyword) {
		System.out.println("미니홈피 찾기 , keyword = "+keyword);
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		return mapper.selectMiniHomepageList(keyword);
	}

	public int increaseTodayTotal(String id) {
		System.out.println("미니홈피 id 방문자수 올리기 = "+id);
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		return mapper.increaseTodayTotal(id);
	}

	public int titleUpdate(String id, String title) {
		System.out.println("미니홈피 title 수정 = "+id+","+title);
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("title", title);
		return mapper.titleUpdate(map);
	}

	public int introduceImgUpdate(MiniHomepage miniHomepage) {
		System.out.println("미니홈피 introduce, img 수정  ");
		MiniHomepageMapper mapper = session.getMapper(MiniHomepageMapper.class);
		return mapper.introduceImgUpdate(miniHomepage);
	}
}
