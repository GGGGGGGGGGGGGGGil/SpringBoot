package kr.co.farmstory.dao;

import kr.co.farmstory.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleDAO {

    public List<ArticleVO> selectArticles();
}
