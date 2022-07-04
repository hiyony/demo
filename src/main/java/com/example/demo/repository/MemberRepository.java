package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;

public interface MemberRepository {

	//会員オブジェクトを保存するリポジトリ
	//회원 객체를 저장하는 리포지토리 

	Member save(Member member); //会員を保存すると保存された会員が変換する　회원을 저장하면 저장된 회원이 반환
	Optional<Member> findById(Long id); //idで会員探す　→　結果がない場合はnull　id로 회원찾기 -> 결과가 없을 경우 null
	Optional<Member> findByName(String name); //名前で会員探す　→　結果がない場合null name으로 회원찾기 -> 결과가 없을 경우 null
	List<Member> findAll(); //全ての会員リスト変換　모든 회원리스트 반환
	
}
