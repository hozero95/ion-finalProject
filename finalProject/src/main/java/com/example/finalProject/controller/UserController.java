package com.example.finalProject.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.UserDto;
import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.util.UserService;

import javassist.bytecode.DuplicateMemberException;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// UserDto를 파라미터로 받아서 UserService의 signup 메소드를 호출
	@PostMapping("/signup")
	public ResponseEntity<UsersVO> signup(@Valid @RequestBody UserDto userDto) throws DuplicateMemberException {
		return ResponseEntity.ok(userService.signup(userDto));
	}

//	// USER, ADMIN 두 가지 권한 모두 호출 허용
//	@GetMapping("/user")
//	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
//	public ResponseEntity<UsersVO> getMyUserInfo() {
//		return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
//	}
//
//	// ADMIN 권한만 호출 허용
//	// UserService에서 만들어진 userId 파라미터를 기준으로 유저 정보와 권한 정보를 리턴하는 API
//	@GetMapping("/user/{userId}")
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	public ResponseEntity<UsersVO> getUserInfo(@PathVariable String userId) {
//		return ResponseEntity.ok(userService.getUserWithAuthorities(userId).get());
//	}
}
