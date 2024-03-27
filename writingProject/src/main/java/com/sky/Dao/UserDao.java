package com.sky.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.Dto.UserDto;




@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserDto> selectAll() {
        List<UserDto> results = jdbcTemplate.query(
                "SELECT * FROM user", // 테이블 이름 확인
                new RowMapper<UserDto>() { // 클래스 이름 수정
                    @Override
                    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserDto user = new UserDto(
                                rs.getString("id"),
                                rs.getString("name"),
                                rs.getString("password"),
                                rs.getString("email")
                                
                        );

                        return user;
                    }
                });

        return results; // 결과 반환
    }
}

