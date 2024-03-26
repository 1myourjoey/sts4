package com.sky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sky.repository.MemberMapper;

import spring.Member;

@SpringBootTest
class Sb03251ApplicationTests {
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	void contextLoads() {
		System.out.println(memberMapper.selectCount());
	}
	@Test
	@DisplayName("내부에서 만든 카운트")
	void innerCount() {
		System.out.println(memberMapper.count());
	}
	
	@Test
	@DisplayName("다오 셀렉")
	void DaoSelect() {
		System.out.println(memberMapper.selectByEmail("0326@0326"));
	}
	
//	@Test
	@DisplayName("다오 인서트")
	void DaoInsert() {
		Member member = Member.builder()
	            .email("example11@example.com")
	            .password("password123")
	            .name("John Doe")
	            .build();
		memberMapper.insert(member);
	}
	@Test
	@DisplayName("다오 업뎃")
	void DaoUpdate() {
		Member member = Member.builder().name("예제").password("5555").email("example11@example.com").build();
		memberMapper.update(member);
	}
	
}
