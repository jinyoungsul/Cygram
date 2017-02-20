package mapper;

import vo.Profile;

public interface ProfileMapper {
	public int insert(Profile profile);
	public int update(Profile profile);
	public Profile select(String id);
}
