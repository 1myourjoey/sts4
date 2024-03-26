package com.sky.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import spring.Member;

@Mapper
public interface MemberMapper {
	int selectCount();
	
	@Select("select count(*) from member")
	int count();
	
	@Select("select * from MEMBER where EMAIL = #{email}")
	Member selectByEmail(String email);
	
	@Insert("INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
	        "VALUES (#{email}, #{password}, #{name}, NOW())")
	void insert(Member member);

	@Update("update MEMBER set NAME = #{name}, PASSWORD = #{password} where EMAIL = #{email}")
	void update(Member member);

}
