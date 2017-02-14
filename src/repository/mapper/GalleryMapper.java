package repository.mapper;

import java.util.List;
import java.util.Map;

import vo.Gallery;

public interface GalleryMapper {
	public int insert(Gallery gallery);
	public Gallery select(int galleryNo);
	public List<Gallery> selectList(Map<String, Integer> map);
	public int selectGalleryCount();
}
