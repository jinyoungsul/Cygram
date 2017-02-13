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
		// 회원가입 절차에 필요한 부가작업이 있으면
		// 여기에서 수행하고 insert 함.(지금은 없음)
		if(memberDao.insert(member)>0)
			return true;
		else
			return false;
	}
}






