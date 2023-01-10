package kr.co.ch07;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.ch07.dao") //맵퍼를 이 패키지 하위에서 찾음
@SpringBootApplication
public class Ch07Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch07Application.class, args);
	}

}
