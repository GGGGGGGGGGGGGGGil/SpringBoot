package kr.co.ch09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch09.vo.User1VO;

@Mapper
@Repository
public interface MemberDAO {
	
	public void insertMember(User1VO vo);
	public User1VO selectMember(String uid);
	public List<User1VO> selectMembers();
	public void updateMember(User1VO vo);
	public void deleteMember(String uid);
}
