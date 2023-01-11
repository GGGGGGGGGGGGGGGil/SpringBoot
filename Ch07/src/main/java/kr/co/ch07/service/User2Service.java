package kr.co.ch07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch07.dao.User2DAO;
import kr.co.ch07.repository.User2Repo;
import kr.co.ch07.vo.User2VO;

@Service
public class User2Service {
	
	@Autowired
	private User2DAO dao;
	
	@Autowired
	private User2Repo repo;
	
	
	public void insertUser2() {}
	public void selectUser2() {}
	public List<User2VO> selectUser2s() {
		List<User2VO> users = repo.findAll();
		
		return users;
	}
	public void updateUser2() {}
	public void deleteUser2() {}
}
