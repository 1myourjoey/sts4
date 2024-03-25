package com.boost.springboostupex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.boost.springboostupex.dao.MemberDao;
import com.boost.springboostupex.dto.Member;

@SpringBootTest
class SpringboostupexApplicationTests {

	@Autowired
	private MemberDao memDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Test
	@DisplayName("jdbc TEST")
	void jdbcTEST () {
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from member where id = ?",1);
		rs.next();
		assertEquals(1, rs.getInt("id"));
	}
	
	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("selectAll() test")
	public void Test() {
		System.out.println(memDao.selectAll());
	}
	//@Test
	@DisplayName("insert() test")
	public void insert() {
		Member member = Member.builder().email("123@123").name("ww").age(2).memo("sd").build();
		memDao.insert(member);
	}
	@Test
	@DisplayName("assertEquals() test")
	public void Testassert() {
		
		int before = memDao.count();
//		Member member = Member.builder().email("6523@123").name("ww").age(2).memo("sd").build();
//		memDao.insert(member);
		int after = memDao.count();
		assertEquals(before,after);
	}
	

}
