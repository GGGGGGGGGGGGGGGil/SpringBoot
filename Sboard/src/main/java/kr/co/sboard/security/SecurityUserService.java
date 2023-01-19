package kr.co.sboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.userRepo;

@Service
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private userRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//시큐리티 호출해서 여기서 처리함
		UserEntity user = repo.findById(username).get();
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		//비밀번호는 시큐리티 객체 만들때 같이 매칭함
		UserDetails userDts = MyUserDetails.builder()
							.user(user)
							.build();
		
		return userDts;
	}
}
