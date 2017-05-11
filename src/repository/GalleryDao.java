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
	
	public List<Gallery> selectList(int startRow, int count,String id){
		System.out.println("selectList error");
		Map<String, Integer> map = new HashMap<>();
		Map<String, Object> map2 = new HashMap<>();
		map2.put("startRow", startRow);
		map2.put("count", count);
		map2.put("id",id);
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryList(map2);
	}
	
	public int selectCount(){
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectGalleryCount();
	}

	public List<GalleryImg> selectImgList(int galleryNo) {
		GalleryMapper mapper = session.getMapper(GalleryMapper.class);
		return mapper.selectImgList(galleryNo);
	}
}
