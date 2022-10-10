package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.book.domain.Member;
import com.book.service.MemberService;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/")
	public String loginForm() {
		return "members/login";
	}
	
	@GetMapping("/members/join")
	public String joinForm() {
		return "members/join";
	}
	
	@PostMapping("/members/join")
	public String join(Member member) {
		memberService.join(member);
		
		return "redirect:/";
	}
	
	@PostMapping("/members/login")
	public String login(Member member) {
		System.out.println("id: " + member.getId() + ", username: " + member.getUsername() + ", password: " + member.getPassword());
		
		boolean loginResult = memberService.login(member.getUsername(), member.getPassword());
		if(loginResult) {
			return "/books/search";
		}else {
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		return "members/memberList";
	}
}
