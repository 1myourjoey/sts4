package com.sky.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.Dao.UserDao;
import com.sky.Dto.UserDto;
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	public List<UserDto> selectAll() {
        return userDao.selectAll();
    }

}
