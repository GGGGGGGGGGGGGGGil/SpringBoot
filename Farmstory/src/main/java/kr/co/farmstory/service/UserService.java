package kr.co.farmstory.service;

import kr.co.farmstory.dao.UserDAO;
import kr.co.farmstory.entity.UserEntity;
import kr.co.farmstory.repository.UserRepo;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO dao;
    @Autowired
    private UserRepo repo;
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
    public int countUser(String uid){
        return repo.countByUid(uid);
    }
    public int countNick(String nick){
        return repo.countByNick(nick);
    }
}
