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
	private static Map<Long, Member> store = new HashMap<>(); //保存するところ
	private static long sequence = 0L; //0, 1, 2, ... こんな方式でキー値を生成する
	
	@Override
	public Member save(Member member) { //会員情報を保存する
		member.setId(++sequence); //IDをセットする時シークエンス値を上がる
		store.put(member.getId(), member); //storeて言うマップにputして情報入れる
		return member; //member値をリターンする
	}

	@Override
	public Optional<Member> findById(Long id) { //idで会員探す
		return Optional.ofNullable(store.get(id)); //Optionalを使ってNPEの発生可能性を減らしてくれる
												   //null値だとしてもリターン可能
	}
	@Override
	public Optional<Member> findByName(String name) { //nameで会員探す
		return store.values().stream() //.stream().filter()で会員探す
				.filter(member -> member.getName().equals(name))
				.findAny(); //.stream().findAny()で条件と合っている予想中一番探した予想をリターン
	}
	@Override
	public List<Member> findAll() { //全ての会員を出力する機能
		return new ArrayList<>(store.values());
	}
	
	public void clearStore() {
		store.clear();
	}

}
