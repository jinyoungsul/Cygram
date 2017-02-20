package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.ProfileMapper;
import vo.Profile;

@Component
public class ProfileDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	//-----------------------------------------------//
	
	public int insert(Profile profile){
		ProfileMapper mapper = session.getMapper(ProfileMapper.class);
		return mapper.insert(profile);
	}
	
	public int update(Profile profile){
		ProfileMapper mapper = session.getMapper(ProfileMapper.class);
		return mapper.update(profile);
	}
	
	public Profile select(String id){
		ProfileMapper mapper = session.getMapper(ProfileMapper.class);
		return mapper.select(id);
			
		}
}
