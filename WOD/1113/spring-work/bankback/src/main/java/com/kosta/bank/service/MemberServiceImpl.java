package com.kosta.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.bank.dao.MemberDao;
import com.kosta.bank.dto.Member;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
	private MemberDao memberDao;

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Member selectMember(String id) throws Exception {
        return memberDao.selectMember(id);
    }

    @Override
    public void insertMember(Member member) throws Exception {
    	Member smember =  selectMember(member.getId());
    	if(smember!=null) throw new Exception("아이디 중복");
        memberDao.insertMember(member);
    }
}
