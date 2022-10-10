package com.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	//회원가입
	@SuppressWarnings("unchecked")
	Member save(Member member);
	
	//회원 찾기, 로그인
	Member findByUsername(String username);
	
	//회원 목록
	List<Member> findAll();	
}
