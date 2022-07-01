package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.MemberService;

//< 동작 >
//@Controller 통해서 외부 요청을 받고 
//@Service 에서 비즈니스 로직을 만들고 
//@Repository 에서 데이터를 저장한다 

@Controller
public class MemberController {
	//스프링 컨테이너에서 스프링 빈이 관리된다 
	//new로 객체를 생성해도 되지만 스프링이 관리하게 되면 모두 스프링 컨테이너에 등록이 되고
	//스프링 컨테이너로부터 받아서 쓰도록 관리 해야한다 
	//하나만 생성해놓고 공용으로 사용할 수 있도록 스프링 컨테이너에 객체 등록 
	
	private final MemberService memberService;

	@Autowired //스프링 컨테이너에 자동으로 객체를 생성해줌 
	public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
}
