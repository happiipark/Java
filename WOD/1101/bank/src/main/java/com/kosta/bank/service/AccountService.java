package com.kosta.bank.service;

import java.util.List;

import com.kosta.bank.dto.Account;

public interface AccountService {
	void makeAccount(Account acc) throws Exception;
	Account accountInfo(String id) throws Exception;
	
	
	void depositAccount(Account acc) throws Exception;
	void withdrawAccount(Account acc) throws Exception;
	List<Account> selectAllAccount() throws Exception;

}
