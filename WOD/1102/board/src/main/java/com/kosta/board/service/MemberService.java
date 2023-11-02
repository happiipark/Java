package com.kosta.board.service;

import com.kosta.board.dto.Member;

public interface MemberService {
	
	
	void joinMember(Member member) throws Exception;
	Member login(String id, String password) throws Exception;

}
