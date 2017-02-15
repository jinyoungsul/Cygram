package mapper;

import java.util.List;

import vo.MiniHomepage;

public interface MiniHomepageMapper {
	public int createMiniHomepage(String id);
	public MiniHomepage selectMiniHomepage(String id);
	public List<MiniHomepage> selectMiniHomepageList(String keyword);
}
