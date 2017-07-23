package mapper;

import java.util.List;
import java.util.Map;

import vo.Gallery;
import vo.GalleryImg;

public interface GalleryMapper {
	public int insert(Gallery gallery);
	public int insertImg(GalleryImg galleryImg);
	public Gallery select(int galleryNo);
	public int update(Gallery gallery);
	public int updateImg(int galleryImgNo);
	
	public List<Gallery> selectGalleryList(Map<String, Integer> map,String id);
	public List<Gallery> selectGalleryList(Map<String, Object> map2);
	public List<Gallery> selectGalleryFriendList(Map<String, Integer> map,String id);
	public List<Gallery> selectGalleryFriendList(Map<String, Object> map2);
	public List<Gallery> selectGalleryPrivateList(Map<String, Integer> map,String id);
	public List<Gallery> selectGalleryPrivateList(Map<String, Object> map2);
	
	public List<GalleryImg> selectImgList(int galleryNo);
	public int selectGalleryCount(String id);
	public int selectGalleryFriendCount(String id);
	public int selectGalleryPrivateCount(String id);
	public int selectNewGalleryCount(String id);
	public int selectNewGalleryFriendCount(String id);
	public int selectNewGalleryPrivateCount(String id);
	
	public int deleteImg(int galleryNo);
	
}
