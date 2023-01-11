package kr.co.ch07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.ch07.vo.User2VO;

@Mapper
@Repository
public interface User2DAO {
	
	public void insertUser2();
	public void selectUser2();
	public List<User2VO> selectUser2s();
	public void updateUser2();
	public void deleteUser2();
}
