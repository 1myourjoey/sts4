package com.sky.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sky.Dao.RecordDao;
import com.sky.Dto.RecordDto;
@Service
public class RecordService {
	@Autowired
	RecordDao recordDao;
	public List<RecordDto> selectAll() {
        return recordDao.selectAll();
    }
	
	public void insert(RecordDto record) {
        recordDao.insertRecord(record);
    }
	
}
