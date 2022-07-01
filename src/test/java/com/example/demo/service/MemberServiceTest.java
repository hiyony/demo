package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberServiceTest {

	MemberService memberService;
	MemoryMemberRepository memberRepository;
	
	//각 함수가 테스트 되기 전마다 실행됨 
	//내가 직접 new 하지 않고 외부에서 memberRepository를 넣어줌 -> DI
	@BeforeEach
	public void beforeEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}
	
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void join() {
		//given
		//에서 멤버객체 받아서 hello를 넣어준다 
		Member member = new Member();
		member.setName("hello");
		
		//when
		//은 상황. memberService에서 join회원가입 시 
		Long saveId = memberService.join(member);
		
		//then
		//저장한 saveId가 리포지토리에 있는게 맞는지 확인후 멤버의 이름이 찾은 멤버의 이름과 같은지 확인
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		try {
			memberService.join(member2);
			fail();
		} catch(IllegalStateException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		}
	}

	@Test
	public void findMembers() {
	}

	@Test
	public void findOne() {
	}

}
