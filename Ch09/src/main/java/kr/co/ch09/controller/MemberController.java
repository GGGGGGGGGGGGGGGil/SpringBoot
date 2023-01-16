package kr.co.ch09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ch09.service.MemberService;
import kr.co.ch09.vo.MemberVO;

@RestController // @RestController로 @ResponseBody 생략가능
public class MemberController {

	@Autowired
	private MemberService service;
	
	@ResponseBody
	@GetMapping("/member")
	public String list() {
	}
	
	@GetMapping("/member/{uid}")
	public String list(String uid) {}
	
	@PostMapping("/register")
	public String register() {}
	
	@PutMapping("/modify")
	public String modify() {}
	
	@PutMapping("/modify")
	public String modify() {}
	
	
}
