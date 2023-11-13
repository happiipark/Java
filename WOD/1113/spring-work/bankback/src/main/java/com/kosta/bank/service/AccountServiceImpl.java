package com.kosta.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.bank.dao.AccountDao;
import com.kosta.bank.dto.Account;

@Service	
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void makeAccount(Account acc) throws Exception {
    	Account sacc =  selectAccount(acc.getId());
    	if(sacc!=null) throw new Exception("계좌번호 중복");
        accountDao.insertAccount(acc);
    }

    @Override
    public Account selectAccount(String id) throws Exception {
    	Account sacc =  accountDao.selectAccount(id);

        return sacc;
        
    }

    @Override
    public void updateAccountBalance(String id,Integer balance) throws Exception {
        accountDao.updateBalance(id,balance);	
    }

    @Override
    public List<Account> selectAccountList() throws Exception{
        return accountDao.selectAccountList();
    }
}
