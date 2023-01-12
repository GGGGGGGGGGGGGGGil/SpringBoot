package kr.co.ch08.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.User3Service;
import kr.co.ch08.vo.User3VO;

@Controller
public class User3Controller {
	
	@Autowired
	private User3Service service;
	
	@GetMapping("/user3/login")
	public String login() {
		return "/user3/login";
	}
	@PostMapping("/user3/login")
	public String login(HttpSession sess, String uid, String pass) {
		User3VO user = service.selectUser3(uid, pass);
		
		if(user != null) {
			//회원이 맞으면
			sess.setAttribute("sessUser", user);
			return "redirect:/user3/loginSuccess";
		}else {
			//회원이 아니면
			return "redirect:/user3/login?success=100";
		}
	}
	
	@GetMapping("/user3/loginSuccess")
	public String loginSuccess() {
		return "/user3/loginSuccess";
	}
	@GetMapping("/user3/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/user3/login?success=101";
	}
}
