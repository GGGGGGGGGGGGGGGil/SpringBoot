package kr.co.ch07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.ch07.vo.User1VO;

public interface User1Repo extends JpaRepository<User1VO, String> {
	
	//JPA 쿼리메서드
	public User1VO findUser1VOByUid(String uid);
	public List<User1VO> findUser1VOByName(String name); //findUser1VOByName의 엔티티 이름(User1VO) 빼도되는데 구분 하기 쉽게 넣음
	public List<User1VO> findUser1VOByNameNot(String name); 	
	
	public List<User1VO> findUser1VOByUidAndName(String uid, String name); //매개변수 두 개
	public List<User1VO> findUser1VOByUidOrName(String uid, String name); 
	
	public List<User1VO> findUser1VOByAgeGreaterThan(int age); //보다 크다
	public List<User1VO> findUser1VOByAgeGreaterThanEqual(int age); //크거나 같다
	public List<User1VO> findUser1VOByAgeLessThan(int age); //보다 작다
	public List<User1VO> findUser1VOByAgeLessThanEqual(int age); //보다 작거나 같다
	
	public List<User1VO> findUser1VOByNameLike(String name); //like 쓸때 name % 앞뒤로 붙여야함
	public List<User1VO> findUser1VOByNameContains(String name); //Contains 많으씀
	public List<User1VO> findUser1VOByNameStartsWith(String name); //like 쓸때 name % 앞뒤로 붙여야함
	public List<User1VO> findUser1VOByNameEndsWith(String name); //like 쓸때 name % 앞뒤로 붙여야함
	
	public List<User1VO> findUser1VOByOrderByName(); 
	public List<User1VO> findUser1VOByOrderByAgeAsc();
	public List<User1VO> findUser1VOByOrderByAgeDesc(); 
	public List<User1VO> findUser1VOByAgeGreaterThanOrderByAgeDesc(int age); //
	
	public int countUser1VOByUid(String uid); //Uid가 PK로 지정됬을 때 값은 1또는 0 그래서 반환값 int임
	public int countUser1VOByName(String name); //Uid가 PK로 지정됬을 때 값은 1또는 0 그래서 반환값 int임
	
	//JPQL
	@Query("SELECT u1 FROM User1VO AS u1 WHERE age < 30") //반드시 AS로 엔티티의 별칭을 주고 사용해야됨, 여기서 쿼리문 씀
	public List<User1VO> selectUserArticle(); //이름은 아무거나 써도되고
	
	@Query("SELECT u1 FROM User1VO AS u1 WHERE u1.name =?1")
	public List<User1VO> selectUserByName(String name);
	
	@Query("SELECT u1 FROM User1VO AS u1 WHERE u1.name = :name")
	public List<User1VO> selectUserByWithParam(@Param("name") String name);
}
