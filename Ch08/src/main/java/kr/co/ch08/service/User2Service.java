package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.ch08.repository.User2Repo;
import kr.co.ch08.vo.User2VO;

@Service
public class User2Service implements UserDetailsService { //스프링 인증 클래서 상속 받아야함
	
	@Autowired
	private User2Repo repo;
	
	
	public void insertUser2() {}
	public User2VO selectUser2(String uid, String pass) {
		return null;
	}
	public void selectUser2s() {}
	public void updateUser2() {}
	public void deleteUser2() {}
	
	@Override 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User2VO user = repo.findById(username).get();
		
		if(user == null) {
			System.out.println("user 없음...");
			throw new UsernameNotFoundException(username);
		}
		
		//로그인 하는데 이게 핵심
		UserDetails userDts = User //core.userdetails.UserDetails 이걸로 해야함
								.builder()
								.username(user.getUid())
								.password(user.getPass())
								.roles("ADMIN").build();
		
		return userDts;
	}
}
