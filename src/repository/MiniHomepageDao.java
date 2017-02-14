package repository;

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
}
