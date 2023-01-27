package kr.co.farmstory.service;

import kr.co.farmstory.dao.ArticleDAO;
import kr.co.farmstory.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO dao;


    public List<ArticleVO> selectArticles(){
        return dao.selectArticles();
    }

}
