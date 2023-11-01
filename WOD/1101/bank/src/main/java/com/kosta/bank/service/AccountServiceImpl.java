package com.kosta.bank.service;

import java.util.List;

import com.kosta.bank.dao.AccountDao;
import com.kosta.bank.dto.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDao.insertAccount(acc);

	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return accountDao.selectAccount(id);
	}

	// deposit
	@Override
	public void depositAccount(Account acc) throws Exception {
		accountDao.updateAccountBalance(acc); 
		
	}

	@Override
	public void withdrawAccount(Account acc) throws Exception {
		accountDao.updateAccountBalance(acc); 
		
		
	}

	@Override
	public List<Account> selectAllAccount() throws Exception {
		return accountDao.selectAccountList();
	}
	
	

}
