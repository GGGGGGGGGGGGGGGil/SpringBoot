package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDAO;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.userRepo;
import kr.co.sboard.vo.TermsVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private userRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public int insertUser(UserEntity vo) {
		vo.setPass(passwordEncoder.encode(vo.getPass2()));
		
		int result = dao.insertUser(vo);
		
		return result;
	}
	public TermsVO selectTerms() {
		return dao.selectTerms();
	}
	public void selectUser() {}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}

	public int countUser(String uid) {
		return repo.countByUid(uid);
	}
	
	public int countNick(String nick) {
		return repo.countByNick(nick);
	}
}
