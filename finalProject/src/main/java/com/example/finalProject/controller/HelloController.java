package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.respository.UsersRepository;

@RestController
@RequestMapping("/api")
public class HelloController {
	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello");
	}

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsersVO>> test() {
		List<UsersVO> users = usersRepository.findAll();
		
		for(UsersVO user : users) {
			System.out.println(user.getUserUnum());
			System.out.println(user.getUserId());
			System.out.println(user.getUserPassword());
			System.out.println(user.getUserEmail());
			System.out.println(user.getUserAddress());
			System.out.println(user.getUserTel());
			System.out.println(user.getUserRegdate());
			System.out.println();
		}
		
		return new ResponseEntity<List<UsersVO>>(users, HttpStatus.OK);
	}
}
