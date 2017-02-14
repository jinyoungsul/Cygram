package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.GalleryMapper;
import vo.Gallery;

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
	
	public Gallery select(int galleryNo){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.select(galleryNo);
	}
	
	public List<Gallery> selectList(int startRow, int count){
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectList(map);
	}
	
	public int selectCount(){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryCount();
	}
}
