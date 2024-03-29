package com.sky.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.Dto.FairyTaleDto;

@Repository
public class FairyTaleDao {
	  @Autowired
	    private JdbcTemplate jdbcTemplate;
	  public List<FairyTaleDto> selectAll() {
	        List<FairyTaleDto> results = jdbcTemplate.query(
	                "SELECT * FROM fairytale", // 테이블 이름 확인
	                new RowMapper<FairyTaleDto>() { // 클래스 이름 수정
	                    @Override
	                    public FairyTaleDto mapRow(ResultSet rs, int rowNum) throws SQLException {
	                    	FairyTaleDto story = new FairyTaleDto(
	                                rs.getString("title"),
	                                rs.getString("content"),
	                                rs.getString("rate"),
	                                rs.getString("writer")
	                                
	                        );

	                        return story;
	                    }
	                });

	        return results; // 결과 반환
	    }
	  public FairyTaleDto selectRandom() {
	        List<FairyTaleDto> allFairyTales = selectAll();
	        Random random = new Random();
	        int randomIndex = random.nextInt(allFairyTales.size());
	        return allFairyTales.get(randomIndex);
	    }
}
