package com.sky.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sky.Dto.RecordDto;

@Repository
public class RecordDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<RecordDto> selectAll() {
		List<RecordDto> results = jdbcTemplate.query("SELECT * FROM record", // 테이블 이름 확인
				new RowMapper<RecordDto>() { // 클래스 이름 수정
					@Override
					public RecordDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						RecordDto record = new RecordDto(

								rs.getString("content"), rs.getString("status"), rs.getString("time"),
								rs.getInt("userNum"), rs.getInt("storyId")

				);

						return record;
					}
				});

		return results; // 결과 반환
	}
	  public void insertRecord(RecordDto record) {
	        String sql = "INSERT INTO record (content, status, time, userNum, storyId) VALUES (?, ?, NOW(), ?, ?)";
	        jdbcTemplate.update(sql, record.getContent(), record.getStatus(), record.getUserNum(), record.getStoryId());
	    }
}
