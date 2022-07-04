package com.example.demo.domain;

import javax.persistence.*;

//ID識別子と名前を受け取る아이디 식별자와 이름 받기
@Entity
public class Member {

	//sql sequence : データに関して自動的に数字をつける
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
