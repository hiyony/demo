package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository{
	private static Map<Long, Member> store = new HashMap<>(); //저장해둘곳 
	private static long sequence = 0L; //0, 1, 2, ... 이런식으로 키 값을 생성해줌 
	
	@Override
	public Member save(Member member) { //회원정보 저장 
		member.setId(++sequence); //아이디 세팅시 시퀀스값을 올려준 다음 
		store.put(member.getId(), member); //store에 put해서 정보 넣어주고 
		return member; //멤버값 리턴 
	}

	@Override
	public Optional<Member> findById(Long id) { //id로 회원찾기 
		return Optional.ofNullable(store.get(id)); //Optional로 감싸서 NPE발생X
												   //null값이어도 리턴 가능!
	}
	@Override
	public Optional<Member> findByName(String name) { //name으로 회원찾기 
		return store.values().stream() //.stream().filter()로 회원찾기 
				.filter(member -> member.getName().equals(name))
				.findAny(); //.stream().findAny()로 조건에 일치하는 요소 중 
							//가장 먼저 탐색되는 요소 리턴 
	}
	@Override
	public List<Member> findAll() { //회원 모두 출력하는 기능 
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}

}
