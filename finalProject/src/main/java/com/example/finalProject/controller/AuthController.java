package com.example.finalProject.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.LoginDto;
import com.example.finalProject.domain.dto.TokenDto;
import com.example.finalProject.jwt.JwtFilter;
import com.example.finalProject.jwt.TokenProvider;

@RestController
@RequestMapping("/api")
public class AuthController {
	private final TokenProvider tokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
		this.tokenProvider = tokenProvider;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
	}

	@PostMapping("/signin")
	public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginDto.getUserId(), loginDto.getUserPassword());

		// authenticate 메소드가 실행이 될 때, CustomUserDetailsService.loadUserByUsername가 실행이 되면서 Authentication 객체를 생성
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		// 생성된 Authentication 객체를 SecurityContext에 저장
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Authentication 객체를 createToken 메소드를 통해서 JWT Token을 생성
		String jwt = tokenProvider.createToken(authentication);

		// 생성된 JWT Token을 Response Header에 넣어줌
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

		// TokenDto를 이용해서 Response Body에도 Token을 넣고 header와 함께 리턴
		return new ResponseEntity<TokenDto>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
	}
}
