package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.VisitorMapper;
import vo.Visitor;

@Component
public class VisitorDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	//-----------------------------------------------//
	
	public int insert(Visitor Visitor){
		VisitorMapper mapper = session.getMapper(VisitorMapper.class);
		return mapper.insert(Visitor);
	}
	
	public int update(Visitor Visitor){
		VisitorMapper mapper = session.getMapper(VisitorMapper.class);
		return mapper.update(Visitor);
	}
	
	public Visitor select(int VisitorNo){
		VisitorMapper mapper = session.getMapper(VisitorMapper.class);
		return mapper.select(VisitorNo);
	}
	
	public List<Visitor> selectVisitorList(int startRow, int count, String id ){
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		VisitorMapper mapper = session.getMapper(VisitorMapper.class);
		return mapper.selectVisitorList(map);
	}
	
	public int selectVisitorCount(){
		VisitorMapper mapper = session.getMapper(VisitorMapper.class);
		return mapper.selectVisitorCount();
	}
	
}
