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
			// JWT ????????? ???????????? ????????? csrf ????????? disable
			.csrf().disable()
			
			// Exception ????????? ????????? ????????? ??????
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.accessDeniedHandler(jwtAccessDeniedHandler)
			
			// ????????? ???????????? ?????? ????????? ?????? ????????? STATELESS??? ??????
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			
			// API ????????? ?????? ?????? ??????
			.and()
			.authorizeRequests()
//			.antMatchers("/api/**").permitAll() // ?????? ????????? ?????? ??????
			.antMatchers("/api/user").hasAnyRole("USER", "ADMIN") // ?????? ?????? ????????????
			.antMatchers("/api/mypage/**").hasAnyRole("USER", "ADMIN") // ???????????????
			.antMatchers("/api/detail/regist/cart").hasAnyRole("USER", "ADMIN") // ??????????????? ?????? ??????
			.antMatchers("/api/cart/**").hasAnyRole("USER", "ADMIN") // ???????????? ?????????
			.antMatchers("/api/pay/**").hasAnyRole("USER", "ADMIN") // ?????? ?????????
			.antMatchers("/api/admin/**").hasAnyRole("ADMIN") // ??????????????????
			.anyRequest().permitAll()
			
			// CORS ??????
			.and()
			.cors()
			
			// JwtFilter??? addFilterBefore??? ????????? JwtSecurityConfig ????????? ??????
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
