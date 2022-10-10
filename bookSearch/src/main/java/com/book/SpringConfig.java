package com.book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.book.repository.MemberRepository;
import com.book.service.MemberService;

@Configuration
public class SpringConfig {
	private MemberRepository memberRepository;

	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	
}
