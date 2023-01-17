package kr.co.ch10;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ch10ApplicationTests {

	@Test //Text 어노테이션이 붙어야 테스트가 실행됨
	void contextLoads() {
		System.out.println("Test 실행...");
	}
}