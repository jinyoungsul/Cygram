package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.GalleryMapper;
import vo.Gallery;
import vo.GalleryImg;

@Component
public class GalleryDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	//------------------------------------------------//
	
	public int insert(Gallery gallery){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.insert(gallery);
	}

	public int insertImg(GalleryImg galleryImg){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.insertImg(galleryImg);
	}

	public Gallery select(int galleryNo){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.select(galleryNo);
	}

	public int update(Gallery gallery){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.update(gallery);		
	}

	public List<Gallery> selectGalleryList(int startRow, int count,String id){
		System.out.println("selectList error");
		Map<String, Integer> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("startRow", startRow);
		map2.put("count", count);
		map2.put("id",id);
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryList(map2);
	}
	
	public List<Gallery> selectGalleryFriendList(int startRow, int count,String id){
		System.out.println("selectList error");
		Map<String, Integer> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("startRow", startRow);
		map2.put("count", count);
		map2.put("id",id);
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryFriendList(map2);
	}
	
	public List<Gallery> selectGalleryPrivateList(int startRow, int count,String id){
		System.out.println("selectList error");
		Map<String, Integer> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("startRow", startRow);
		map2.put("count", count);
		map2.put("id",id);
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryPrivateList(map2);
	}
	
	//--------------����ø ī��Ʈ---------------------------------------//
	
	public int selectGalleryCount(String id){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryCount(id);
	}
	
	public int selectFriendCount(String id){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryFriendCount(id);
	}
	
	public int selectPrivateCount(String id){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryPrivateCount(id);
	}
	
	public List<GalleryImg> selectImgList(int galleryNo) {
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		System.out.println("갤러리번호:"+galleryNo);
		return mapper.selectImgList(galleryNo);
	}

	public int selectNewGalleryCount(String id) {
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectNewGalleryCount(id);
	}

	public int deleteImg(int galleryNo) {
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.deleteImg(galleryNo);
	}

	public int updateImg(Integer galleryImgNo) {
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.updateImg(galleryImgNo);
		
	}
}
