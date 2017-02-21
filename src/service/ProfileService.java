package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ProfileDao;
import vo.Profile;

@Component
public class ProfileService {
	@Autowired
	private ProfileDao profileDao;
	public void setProfileDao(ProfileDao profileDao){
		this.profileDao=profileDao;
	}
	//--------------------------------------------//
	
	public int write(Profile profile){
		int result = 0;
		
		profile.setWriteDate(new Date());
		
		result=profileDao.insert(profile);
		return result;
	}
	
	public int modify(Profile profile, String id){
		int result=0;
		profile.setWriteDate(new Date());
		
		if(id.equals(profile.getId())){
			result = profileDao.update(profile);
		}
		return result;
	}
	
	public Profile read(String id){
		Profile profile = profileDao.select(id);
		return profile;
	}
	
}
