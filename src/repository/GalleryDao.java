package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.GalleryMapper;
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
	
	public List<Gallery> selectList(int startRow, int count){
		System.out.println("리스트 보임?");
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryList(map);
	}
	
	public int selectCount(){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryCount();
	}
}
