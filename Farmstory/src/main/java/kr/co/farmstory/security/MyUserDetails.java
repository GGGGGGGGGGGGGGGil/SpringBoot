package kr.co.farmstory.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kr.co.farmstory.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder 
public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	//시큐리티에서 사용자 정보 객체를 커스텀해서 만듬
	@Autowired
	private UserEntity user;
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 계정이 갖는 권한목록 리턴
		List<GrantedAuthority> authoritiies = new ArrayList<>();
		authoritiies.add(new SimpleGrantedAuthority("ROLE_"+user.getGrade())); //ROLE_ 로 무조건 시작!
		return authoritiies;
	}

	@Override
	public String getPassword() {
		// 계정이 갖는 비밀번호
		
		return user.getPass();
	}

	@Override
	public String getUsername() {
		// 계정이 갖는 아이디
		
		return user.getUid();
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
