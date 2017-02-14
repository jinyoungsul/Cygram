package mapper;

import vo.MiniHomepage;

public interface MiniHomepageMapper {
	public int createMiniHomepage(String id);
	public MiniHomepage selectMiniHomepage(String id);
}
