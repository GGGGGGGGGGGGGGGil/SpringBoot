package kr.co.ch06.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor //생성자 두개 
@NoArgsConstructor 
@ToString
public class UserVO {
	
	private String uid;
	private String name;
	private String hp;
	private int age;
	
}
