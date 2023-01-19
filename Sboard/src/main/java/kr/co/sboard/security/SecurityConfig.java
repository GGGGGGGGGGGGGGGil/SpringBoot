package kr.co.sboard.security;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 인가(접근권한) 설정
		http.authorizeRequests().antMatchers("/").permitAll(); //permitAll - 모든 사용자 허용
		http.authorizeRequests().antMatchers("/list").hasAnyRole("2", "3", "4", "5"); //앞에 Roll_ 생략가능
		http.authorizeRequests().antMatchers("/write").hasAnyRole("3", "4", "5");
		http.authorizeRequests().antMatchers("/view").hasAnyRole("3", "4", "5");
		http.authorizeRequests().antMatchers("/modify").hasAnyRole("3", "4", "5");
		
		// 사이트 위조 방지 설정 - 배포할때는 꺼야함
		http.csrf().disable();
		
		// 로그인 설정(나중에 인증 필요하면 써야함)
		http.formLogin()
		.loginPage("/user/login")
		.defaultSuccessUrl("/list")
		.failureUrl("/user/login?success=100")
		.usernameParameter("uid")
		.passwordParameter("pass");
		
		// 로그아웃 설정
		http.logout()
		.invalidateHttpSession(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
		.logoutSuccessUrl("/user/login?success=200");
	}
	
	@Autowired
	private SecurityUserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Security 사용자에 대한 권한 설정
		//auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN"); //noop으로 암호화된 비번을 평문화 해줌
		//auth.inMemoryAuthentication().withUser("manager").password("{noop}1234").roles("MANAGER"); //noop으로 암호화된 비번을 평문화 해줌
		//auth.inMemoryAuthentication().withUser("member").password("{noop}1234").roles("MEMBER"); //noop으로 암호화된 비번을 평문화 해줌
		
		//로그인 인증 처리 서비스, 암호화 방식 설정
		//예전 방식 처리 auth.userDetailsService(userService).passwordEncoder(new MessageDigestPasswordEncoder("SHA-256"));
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}