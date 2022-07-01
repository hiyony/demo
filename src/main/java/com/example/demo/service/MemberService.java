package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;


//member join service 
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	
	//constructor
	//memberservice를 스프링에 등록할때 @Autowired를 확인하고 
	//스프링 컨테이너에 있는 memorymemberrepository를 주입시켜줌 
	
	@Autowired 
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	

	public Long join(Member member) {
	
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		//같은 이름이 있는 중복회원은 안됨 
		
		memberRepository.findByName(member.getName())
		.ifPresent(m ->{
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
		
	}
	
	public List<Member> findMembers(){
		//search all members
		
		return memberRepository.findAll();
	}
	
	public Optional <Member> findOne(Long memberId){
		//search one member
		
		return memberRepository.findById(memberId);
	}
}
