package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.form.MemberForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//< 동작 >
//@Controller　を通じて外部の要請をもらう
//@Service でビジネスロジックを作る
//@Repository にデータを保存する

@Controller
public class MemberController {
	//スプリングコンテナでスプリングビーンが管理される
	//newでオブジェクトを生成してもいいが、スプリングが管理すると全てスプリングコンテナに登録され
	//スプリングコンテナから受け取るよう管理しなければならない
	//一つだけ生成して置いて共用で使用できるようにスプリングコンテナにオブジェクトを登録する

	
	private final MemberService memberService;

	@Autowired //スプリングコンテナに自動的にオブジェクトを生成する스프링 컨테이너에 자동으로 객체를 생성해줌
	public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	@GetMapping("/members/new") //urlから要請された値を受け取れるurl에서 요청했을 때 값이 넘어온다
	public String createForm() {
		return "members/createMemberForm";
	}

	@GetMapping("/members")
	public String list(Model model){
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);

		return "members/memberList";
	}

	@PostMapping("/members/new") //データをフォームに書いて送る時主に使う데이터를 폼에 적어서 전달할 때 주로 쓰인다
	public String create(MemberForm form){
		Member member = new Member();
		member.setName(form.getName());

		memberService.join(member);
		return "redirect:/";
	}
}
