package com.kosta.bank.service;

import java.util.List;

import com.kosta.bank.dto.Account;

public interface AccountService {
    void makeAccount(Account acc) throws Exception;
    
    Account selectAccount(String id) throws Exception;

    void updateAccountBalance(String id,Integer balance) throws Exception;

    List<Account> selectAccountList() throws Exception;
}
