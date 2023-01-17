package kr.co.ch09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	@GetMapping("/member/list")
	public String list() {
		return "/member/list";
	}
	@PostMapping("/member/list")
	public String list(String uid) {
		return "/member/list";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	@GetMapping("/member/modify")
	public String modify() {
		return "/member/modify";
	}
	@GetMapping("/member/delete")
	public String delete() {
		return "/member/delete";
	}
	
}
