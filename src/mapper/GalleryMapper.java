package mapper;

import java.util.List;
import java.util.Map;

import vo.Gallery;
import vo.GalleryImg;

public interface GalleryMapper {
	public int insert(Gallery gallery);
	public int insertImg(GalleryImg galleryImg);
	public Gallery select(int galleryNo);
	public List<Gallery> selectGalleryList(Map<String, Integer> map,String id);
	public int selectGalleryCount();
	public List<Gallery> selectGalleryList(Map<String, Object> map2);
	public List<GalleryImg> selectImgList(int galleryNo);
}
