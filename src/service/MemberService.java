package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDao;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
///////////////////////////////////////////////////////
	public boolean join(Member member){
	
		if(memberDao.insert(member)>0)
			return true;
		else
			return false;
	}
	public Member selectMember(String id) {
		
		return memberDao.selectMember(id);
	}
	public boolean login(String id, String password) {
		Member savedMember = memberDao.selectMember(id);
		if(savedMember == null || savedMember.getPassword().equals(password) == false){
			return false;
		} else {
			return true;
		}
	}
}






