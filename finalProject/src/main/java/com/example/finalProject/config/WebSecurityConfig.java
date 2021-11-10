package com.example.finalProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.finalProject.jwt.JwtAccessDeniedHandler;
import com.example.finalProject.jwt.JwtAuthenticationEntryPoint;
import com.example.finalProject.jwt.JwtSecurityConfig;
import com.example.finalProject.jwt.TokenProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final TokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	public WebSecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
			JwtAccessDeniedHandler jwtAccessDeniedHandler) {
		this.tokenProvider = tokenProvider;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/favicon.ico");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			// JWT 토큰을 사용하기 때문에 csrf 설정을 disable
			.csrf().disable()
			
			// Exception 핸들링 커스텀 클래스 추가
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.accessDeniedHandler(jwtAccessDeniedHandler)
			
			// 세션을 사용하지 않기 때문에 세션 설정을 STATELESS로 설정
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			
			// API 요청에 대한 권한 설정
			.and()
			.authorizeRequests()
//			.antMatchers("/api/**").permitAll() // 전체 사용자 사용 가능
			.antMatchers("/api/user").hasAnyRole("USER", "ADMIN") // 본인 정보 불러오기
			.antMatchers("/api/mypage/**").hasAnyRole("USER", "ADMIN") // 마이페이지
			.antMatchers("/api/detail/regist/cart").hasAnyRole("USER", "ADMIN") // 장바구니에 저장 기능
			.antMatchers("/api/admin/**").hasAnyRole("ADMIN") // 관리자페이지
			.anyRequest().permitAll()
			
			// CORS 설정
			.and()
			.cors()
			
			// JwtFilter를 addFilterBefore로 등록한 JwtSecurityConfig 클래스 적용
			.and()
			.apply(new JwtSecurityConfig(tokenProvider));
	}
	
	// CORS configured
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:8001");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
