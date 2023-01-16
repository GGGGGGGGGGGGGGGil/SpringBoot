package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import kr.co.ch09.dao.MemberDAO;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepo repo;
	
	
	public void insertMember(MemberVO vo) {
		repo.save(vo);
	}
	public void	selectMember(String uid) {
		return repo.find
	}
	public List<MemberVO> selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
}
