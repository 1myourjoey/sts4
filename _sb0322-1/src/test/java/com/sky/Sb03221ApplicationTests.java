package com.sky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sky.dto.Emp;
import com.sky.mapper.EmpMapper;

@SpringBootTest
class Sb03221ApplicationTests {

	@Autowired
	EmpMapper empMapper;
	
	@Test
	@DisplayName("카운트")
	void contextLoads() {
		System.out.println(empMapper.selectCount());
	}
	@Test
	@DisplayName("리스트 목록")
	void empListTest() {
		for (Emp dto : empMapper.selectEmpList()) {
			System.out.println(dto);
		}
	}
	@Test
	@DisplayName("회원 추가")
	public void insert() {
		Emp dto = Emp.builder().empno(8200).ename("춘향이").job("부인").mgr(7777).sal(9999).comm(4000).deptno(20).build();
		
		empMapper.insertEmp(dto);
		
	}
	@Test
	@DisplayName("회원 업데이트")
	void update() {
		Emp dto = Emp.builder().ename("심청이").job("효녀").mgr(7839).sal(3355).comm(2).deptno(30).empno(7777).build();
		
		empMapper.updateEmp(dto);
	}
	
	@Test
	@DisplayName("삭제")
	void delete() {
		empMapper.deleteBoard(7766);
	}
}