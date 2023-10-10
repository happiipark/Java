package service;

import bean.Member;

public interface MemberService {
	
	void joinMember(Member member) throws Exception;
	Member idDoubleChk(String id) throws Exception;
	Member login(String id, String password) throws Exception;

}
