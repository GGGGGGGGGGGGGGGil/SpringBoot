package kr.co.sboard.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private int age;
	private String rdate;
	
	//시큐리티에서 사용자 정보 객체를 커스텀해서 만듬

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖는 권한목록 리턴
		Collection<GrantedAuthority> collector = new ArrayList<>();
		
		return collector;
	}

	@Override
	public String getPassword() {
		// 계정이 갖는 비밀번호
		
		return pass;
	}

	@Override
	public String getUsername() {
		// 계정이 갖는 아이디
		
		return uid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정 만료 여부 확인(true : 만료안됨, false : 만료)
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠긴 여부(true : 잠김안됨, false : 잠긴)
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 계정 비밀번호 만료 여부(true : 만료안됨, false : 만료)
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 활성화 여부(true : 활성화, false : 비활성화)
		
		return true;
	}
}
