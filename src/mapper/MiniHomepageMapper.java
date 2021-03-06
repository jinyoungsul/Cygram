package mapper;

import java.util.List;
import java.util.Map;

import vo.MiniHomepage;

public interface MiniHomepageMapper {
	public int createMiniHomepage(String id);
	public MiniHomepage selectMiniHomepage(String id);
	public List<MiniHomepage> selectMiniHomepageList(Map<String, Object> map);
	public int increaseTodayTotal(String id);
	public int titleUpdate(Map<String, String> map);
	public int introduceImgUpdate(MiniHomepage miniHomepage);
}
