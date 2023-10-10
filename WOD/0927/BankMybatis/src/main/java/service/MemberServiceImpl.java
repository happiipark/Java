package service;

import bean.Member;
import dao.MemberDAO;
import dao.MemberDAOOImpl;

public class MemberServiceImpl implements MemberService{

	private MemberDAO memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDAOOImpl();
	}

	@Override
	public void joinMember(Member member) throws Exception {
		memberDao.insertMember(member);
		
	}
	// id 중복 체크
	@Override
	public Member idDoubleChk(String id) throws Exception {
		Member member = memberDao.idDoubleChk(id);
		return member;
	}
	// login
	@Override
	public Member login(String id, String password) throws Exception {
		Member m = memberDao.login(id);
		if(m == null) throw new Exception("id오류");
		return m;
	}
	
	

}
