package com.kosta.bank.service;

import com.kosta.bank.dto.Member;

public interface MemberService {
    Member selectMember(String id) throws Exception;
    void insertMember(Member member) throws Exception;
}
