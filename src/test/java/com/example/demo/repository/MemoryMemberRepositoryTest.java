package com.example.demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;

public class MemoryMemberRepositoryTest {
	
	//JUnit으로 실행이 가능한지 검사하기 위한 클래스 
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring"); //name을 spring 세팅해줌 
		
		repository.save(member); //그대로 멤버에 저장 
		
		Member result = repository.findById(member.getId()).get(); 
					//그 멤버의 아이디를 찾아서 result 변수에 새로 저장 
		
		System.out.println("result is " + (result == member));
		Assertions.assertThat(member).isEqualTo(result);
	}
}
