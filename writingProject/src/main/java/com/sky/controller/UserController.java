package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.Dto.UserDto;
import com.sky.Service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
	@GetMapping("userList")
	public String userList(Model model) {
		 List<UserDto> users = userService.selectAll();
		    model.addAttribute("users", users);
		return "userList";
	}
}
