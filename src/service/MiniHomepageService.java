package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MiniHomepageDao;
import vo.MiniHomepage;

@Component
public class MiniHomepageService {
	@Autowired
	private MiniHomepageDao dao;

	public void setDao(MiniHomepageDao dao) {
		this.dao = dao;
	}
	
	public int createMiniHomepage(String id){
		return dao.createMiniHomepage(id);
	}
	public MiniHomepage selectMiniHomepage(String id){
		return dao.selectMiniHomepage(id);
	}

	public List<MiniHomepage> selectMiniHomepageList(String keyword) {
		return dao.selectMiniHomepageList(keyword);
	}

	public int increaseTodayTotal(String id) {
		 return dao.increaseTodayTotal(id);
		
	}

	public int titleUpdate(String id, String title) {
		return dao.titleUpdate(id,title);
	}

	public int introduceImgUpdate(MiniHomepage miniHomepage) {
		return dao.introduceImgUpdate(miniHomepage);
	}
}
