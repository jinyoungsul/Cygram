package service;

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
}
