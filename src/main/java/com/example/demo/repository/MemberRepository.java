package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;

public interface MemberRepository {

	//회원 객체를 저장하는 리포지토리 

	Member save(Member member); //회원을 저장하면 저장된 회원이 반환 
	Optional<Member> findById(Long id); //id로 회원찾기 -> 결과가 없을 경우 null
	Optional<Member> findByName(String name); //name으로 회원찾기 -> 결과가 없을 경우 null
	List<Member> findAll(); //모든 회원리스트 반환 
	
}
