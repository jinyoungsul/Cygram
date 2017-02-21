package mapper;

import java.util.List;
import java.util.Map;

import vo.Visitor;

public interface VisitorMapper {
	public int insert(Visitor visitor);
	public int update(Visitor visitor);
	public Visitor select(int VisitorNo);
	public List<Visitor> selectVisitorList(Map<String, Object> map);
	public int selectVisitorCount();	
}
