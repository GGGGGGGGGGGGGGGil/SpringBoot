package kr.co.ch08.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.ch08.service.User2Service;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 접근 권한 설정
		http.authorizeRequests().antMatchers("/").permitAll(); //permitAll - 모든 사용자 허용
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN"); //ADMIN 권한 가진 사람만 가능
		http.authorizeRequests().antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER");
		http.authorizeRequests().antMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER");
		// 게스트는 permitAll로 처리 하면되서 따로 설정할 필요X
		
		// 사이트 위조 방지 설정
		http.csrf().disable();
		
		// 로그인 설정
		http.formLogin()
		.loginPage("/user2/login")
		.defaultSuccessUrl("/user2/loginSuccess")
		.usernameParameter("uid")
		.passwordParameter("pass");
		
		// 로그아웃 설정(나중에 재설정 필요)
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user2/logout"))
		.logoutSuccessUrl("/user2/login");
	}
	
	@Autowired
	private User2Service service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Security 사용자에 대한 권한 설정
		auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN"); //noop으로 암호화된 비번을 평문화 해줌
		auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER"); //noop으로 암호화된 비번을 평문화 해줌
		auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER"); //noop으로 암호화된 비번을 평문화 해줌
		
		//로그인 인증 처리 서비스, 암호화 방식 설정
		//auth.userDetailsService(service).passwordEncoder(new MessageDigestPasswordEncoder("SHA-256"));
		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
	}
}