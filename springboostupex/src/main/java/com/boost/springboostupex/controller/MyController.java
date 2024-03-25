package com.boost.springboostupex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boost.springboostupex.dto.Member;

import com.boost.springboostupex.service.MemberService;
import com.boost.springboostupex.service.WrongEmailException;

@Controller
public class MyController {
//	@Autowired
//	private MemberDao memberDao;
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String root(Model model) {
		List<Member> members = memberService.selectAll();
		model.addAttribute("members", members); // 모델에 회원 목록 추가
		return "root";
	}

	@PostMapping("/save")
	public String save(@RequestParam("name") String name, 
			@RequestParam("age") int age,
			@RequestParam("email") String email, 
			@RequestParam("memo") String memo) {
		Member newMember = new Member(name, age, email, memo);
		memberService.insert(newMember);
		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deleteMember(@RequestParam("id") int memberId) {
		memberService.delete(memberId);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String UpdatePage(@RequestParam("id") int memberId, Model model) {
		Member member = memberService.findById(memberId);
		model.addAttribute("member", member);

		List<Member> members = memberService.selectAll();
		model.addAttribute("members", members);

		return "edit";
	}

	@PostMapping("/update")
	public String updateMember(@ModelAttribute Member member) {
		memberService.update(member);
		return "redirect:/";
	}
	
    }

