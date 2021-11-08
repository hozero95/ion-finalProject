package com.example.finalProject.util;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.finalProject.domain.dto.UserDto;
import com.example.finalProject.domain.entity.Authority;
import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.respository.UsersRepository;

import javassist.bytecode.DuplicateMemberException;

@Service
public class UserService {
	private final UsersRepository usersRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
		this.usersRepository = usersRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// 회원가입 로직을 수행하는 메소드
	@Transactional
	public UsersVO signup(UserDto userDto) throws DuplicateMemberException {
		// userId가 DB에 존재하는지 검사
		if (usersRepository.findOneWithAuthoritiesByUserId(userDto.getUserId()).orElse(null) != null) {
			throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
		}
		
		// userId가 DB에 존재하지 않는다면 아래 로직 수행
		// Authority 정보와 User 정보 생성 
		Authority authority = Authority.builder()
				.authorityName("ROLE_USER")
				.build();

		UsersVO user = UsersVO.builder()
				.userId(userDto.getUserId())
				.userPassword(passwordEncoder.encode(userDto.getUserPassword()))
				.userEmail(userDto.getUserEmail())
				.userAddress(userDto.getUserAddress())
				.userTel(userDto.getUserTel())
				.userRegdate(new Date())
				.authorities(Collections.singleton(authority))
				.build();

		// UserRepository의 save 메소드를 통해 DB에 정보를 저장
		return usersRepository.save(user);
	}
	
	// 유저, 권한 정보를 가져오는 메소드 2가지
	// 이 두 가지 메소드의 허용권한을 다르게 해서 권한 검증에 대한 부분을 처리
	// userId를 기준으로 정보를 가져오는 메소드
	@Transactional(readOnly = true)
	public Optional<UsersVO> getUserWithAuthorities(String userId) {
		return usersRepository.findOneWithAuthoritiesByUserId(userId);
	}
	// SecurityContext에 저장된 userId의 정보만 가져오는 메소드
	@Transactional(readOnly = true)
	public Optional<UsersVO> getMyUserWithAuthorities() {
		return SecurityUtil.getCurrentUsername().flatMap(usersRepository::findOneWithAuthoritiesByUserId);
	}
	
	public Boolean getUserId(String userId) {
		return usersRepository.existsByUserId(userId);
	}
}
