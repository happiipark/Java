package dao;

import bean.Member;

public interface MemberDAO {
	
	// id 중복 체크
	Member idDoubleChk(String id) throws Exception;
	
	
	// 회원 가입
	void insertMember(Member member) throws Exception;
	
	// Login
	Member login(String id) throws Exception;

}
