package mapper;

import vo.Member;

public interface MemberMapper {
	public int insertMember(Member member);

	public Member selectMember(String id);
}
