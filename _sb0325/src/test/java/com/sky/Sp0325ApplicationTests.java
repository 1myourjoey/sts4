package com.sky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sky.dto.BoardDto;
import com.sky.mapper.BoardMapper;

@SpringBootTest
class Sp0325ApplicationTests {
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	void contextLoads() {
	}
	@Test
	@DisplayName("member Table Count")
	void memberCount() {
		System.out.println(boardMapper.selectCount());
		
	}
	@Test
	@DisplayName("member Table list")
	void memberList() {
		for (BoardDto dto : boardMapper.selectBoardList()) {
			System.out.println(dto);
		}
		
	}
//	@Test
	@DisplayName("insert() test")
	public void insert() {
		BoardDto dto = BoardDto.builder().email("33@333").name("춘향").password("ww").build();
		
		boardMapper.insertBoard(dto);
		
	}
//	@Test
	@DisplayName("delete")
	void delete() {
		boardMapper.deleteBoard(11);
	}
	@Test
	@DisplayName("update")
	void update() {
		BoardDto dto = BoardDto.builder().email("0325@0325").name("길동").password("vmvm").id(13).build();
		
		boardMapper.updateBoard(dto);
	}
	
}