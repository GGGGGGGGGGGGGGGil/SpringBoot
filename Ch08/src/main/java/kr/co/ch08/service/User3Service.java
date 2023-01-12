package kr.co.ch08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch08.repository.User3Repo;
import kr.co.ch08.vo.User3VO;

@Service
public class User3Service {
	
	@Autowired
	private User3Repo repo;

	
	public void insertUser3() {}
	public User3VO selectUser3(String uid, String pass) {
		return repo.findUser3VOByUidAndPass(uid, pass);
	}
	public void selectUser3s() {}
	public void updateUser3() {}
	public void deleteUser3() {}
}
