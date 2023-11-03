package com.kosta.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.board.dto.Member;
import com.kosta.board.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
		try {
			Member member = memberService.login(id, password);
			member.setPassword("");
			session.setAttribute("user", member);
			return "main";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err", e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		session.removeAttribute("user");
		return "main";
	}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(Member member) {
		ModelAndView mav = new ModelAndView();
		
		try {
			memberService.joinMember(member);
			mav.setViewName("login");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value="/idcheck", method = RequestMethod.POST)
	@ResponseBody
	public String idcheck(@RequestParam("id") String id) {
		
		try {
			System.out.println("중복체크");
			Member member = memberService.selectMember(id);
			System.out.println("중복체크 : " + member);
			if(member!=null) return "error";
			return "notexist";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}

}
