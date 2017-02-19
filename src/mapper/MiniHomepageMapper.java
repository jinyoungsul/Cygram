package mapper;

import java.util.List;
import java.util.Map;

import vo.MiniHomepage;

public interface MiniHomepageMapper {
	public int createMiniHomepage(String id);
	public MiniHomepage selectMiniHomepage(String id);
	public List<MiniHomepage> selectMiniHomepageList(String keyword);
	public int increaseTodayTotal(String id);
	public int titleUpdate(Map<String, String> map);
}
