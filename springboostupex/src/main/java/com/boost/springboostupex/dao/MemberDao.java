package com.boost.springboostupex.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boost.springboostupex.dto.Member;

@Repository
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	

//	public Member selectByEmail(String email) {
//		List<Member> results = jdbcTemplate.query("select * from member where email =?",
//				new RowMapper<Member>() {
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum)
//				throws SQLException {
//				Member member = new Member (
//						rs.getString("EMAIL"),
//						rs.getString("PASSWORD"),
//						rs.getString("NAME"),
//						rs.getTimestamp("REGDATE").toLocalDateTime());
//				member.setId(rs.getLong("ID"));
//						return member;
//						
//			}
//		}, email);
//		return results.isEmpty()? null:results.get(0);
//	}
//	
//	public Member selectByEmail2(String email) {
//		Member results = jdbcTemplate.queryForObject("select * from member where email =?",
//				new RowMapper<Member>() {
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum)
//				throws SQLException {
//				Member member = new Member (
//						rs.getString("EMAIL"),
//						rs.getString("PASSWORD"),
//						rs.getString("NAME"),
//						rs.getTimestamp("REGDATE").toLocalDateTime());
//				member.setId(rs.getLong("ID"));
//						return member;
//						
//			}
//		}, email);
//		return results;
//	}
//	
//	public Member selectByEmail3(String email) {
//		List<Member> results = jdbcTemplate.query("select * from member where email =?",
//				
//				(rs,rowNum) -> { 
//				Member member = new Member (
//						rs.getString("EMAIL"),
//						rs.getString("PASSWORD"),
//						rs.getString("NAME"),
//						rs.getTimestamp("REGDATE").toLocalDateTime());
//				member.setId(rs.getLong("ID"));
//						return member;
//		}, email);
//		return results.isEmpty()? null:results.get(0);
//	}
//	public void insert(Member member) {
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement pstmt =con.prepareStatement
//						("insert into member (email, password, name, regdate) values (?,?,?,now())", new String[] {"ID"});
//				pstmt.setString(1, member.getEmail());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getName());
//				
//				return pstmt;
//			}
//		}, keyHolder);
//		Number keyValue = keyHolder.getKey();
//		member.setId(keyValue.longValue());
//	}
//	
//	public void insert2(Member member) {
//		jdbcTemplate.update("insert into member (email, password, name, regdate) values (?,?,?,now())"
//				, member.getEmail(), member.getPassword(), member.getName());
//	}
//
	

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
				"select * from member",
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum)
				throws SQLException {
				Member member = new Member (
						 rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("email"),
						rs.getString("memo"));
				
						return member;
						
			}
		});
		return results;
	}
	  public void insert(Member member) {
	        jdbcTemplate.update(
	            "INSERT INTO member (name, age, email, memo) VALUES (?, ?, ?, ?)",
	            member.getName(), member.getAge(), member.getEmail(), member.getMemo()
	        );
	    }
	  public void delete(int id) {
		    jdbcTemplate.update("DELETE FROM member WHERE id = ?", id);
		}
	  
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
	}
	
	public Member findById(int id) {
	    return jdbcTemplate.queryForObject(
	        "SELECT * FROM member WHERE id = ?",
	        new Object[]{id},
	        (rs, rowNum) -> {
	            int memberId = rs.getInt("id");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	            String memo = rs.getString("memo");
	            Member member = new Member(memberId, name, age, email, memo);
	            return member;
	        }
	    );
	}
	public void update(Member member) {
	    jdbcTemplate.update(
	        "UPDATE member SET name=?, age=?, email=?, memo=? WHERE id=?",
	        member.getName(), member.getAge(), member.getEmail(), member.getMemo(), member.getId()
	    );
	}
	}

