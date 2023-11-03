package com.kosta.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.board.dao.MemberDao;
import com.kosta.board.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;



	@Override
	public void joinMember(Member member) throws Exception {
		memberDao.insertMember(member);
		
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) throw new Exception("아이디 오류");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호 오류");
		return member;
	}

	@Override
	public Member selectMember(String id) throws Exception {
		return memberDao.selectMember(id);
	}

}
