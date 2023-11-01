package com.kosta.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.bank.dto.Account;
import com.kosta.bank.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.GET)
	public String makeAccount() {
		return "makeaccount";
	}
	
	@RequestMapping(value="/makeaccount", method=RequestMethod.POST)
	public String makeAccount(@ModelAttribute Account acc, Model model) {
		
		try {
			accountService.makeAccount(acc);
			Account sacc = accountService.accountInfo(acc.getId());
			model.addAttribute("acc",sacc);
			return "accountinfo";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("err","계좌 개설 실패");
			return "error";
		}
		
		
		
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.POST)
	public String deposit(@ModelAttribute Account acc, Model model) {
		
		
		try {
			Account sacc = accountService.accountInfo(acc.getId());
			sacc.deposit(acc.getBalance());
			accountService.depositAccount(sacc);
			model.addAttribute("acc",sacc);
			return "accountinfo";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("err","- 금액은 입금 할 수 없습니다.");
			return "error";
			
		}
	}
	
	
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public String withdraw(@ModelAttribute Account acc, Model model) {
			
			
			try {
				Account sacc = accountService.accountInfo(acc.getId());
				sacc.withdraw(acc.getBalance());
				accountService.withdrawAccount(sacc);
				model.addAttribute("acc",sacc);
				return "accountinfo";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("err","가지고 있는 금액보다 큰 돈을 인출할 수 없습니다.");
				return "error";
				
			}
		}
	
	@RequestMapping(value="/accountinfo", method=RequestMethod.GET)
	public String accountinfo() {
		return "accountinfoform";
	}
	
	@RequestMapping(value="/accountinfo", method=RequestMethod.POST)
	public String accountinfo(@RequestParam("id") String id, Model model) {
		
		try {
			Account acc = accountService.accountInfo(id);
			model.addAttribute("acc",acc);
			return "accountinfo";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("err","계좌 조회 실패");
			return "error";
		}
	}
	
	@RequestMapping(value="/allaccountinfo", method=RequestMethod.GET)
	public String allaccountinfo(Model model) {
		
		try {
			List<Account> arry = accountService.selectAllAccount();
			model.addAttribute("accs", arry); 
			return "allaccountinfo";
		} catch(Exception e) {
			e.printStackTrace(); 
			return "error";
		}
	}

}
