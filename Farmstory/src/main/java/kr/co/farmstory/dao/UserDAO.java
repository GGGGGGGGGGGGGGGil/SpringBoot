package kr.co.farmstory.dao;

import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {

    public int insertUser(UserEntity vo);
    public TermsVO selectTerms();
}
