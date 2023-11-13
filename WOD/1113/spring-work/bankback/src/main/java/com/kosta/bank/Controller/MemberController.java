package com.kosta.bank.Controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.bank.dto.Member;
import com.kosta.bank.service.MemberService;

@Controller
public class MemberController {
	
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login( String id,  String password, Model model){
        try{
            Member member = memberService.selectMember(id);
            if(member == null || !member.getPassword().equals(password)){
                model.addAttribute("err", "로그인 실패");
                return "error";
            }
            session.setAttribute("user", member);
            return "main";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            model.addAttribute("err", "에러 발생");
            return "error";
        }
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
	public String join(/*String id, String name, String password, String email,
			String address*/  Member member , Model model){
//        Member member = new Member(id, name, password, email, address);
        try{
            memberService.insertMember(member);
            return "redirect:/login";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            model.addAttribute("err", e.getMessage());
            return "redirect:/loginerror?err="+URLEncoder.encode(e.getMessage());
        }
    }	
    
    @GetMapping("/loginerror")
    public String error(@RequestParam("err") String err,Model model ){
    	model.addAttribute("err",err);
    	return "error";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("member");
        return "main";
    }
}
