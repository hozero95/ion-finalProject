package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.UsersVO;
import com.example.finalProject.api.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;

	public List<UsersVO> findAll() {
		List<UsersVO> users = new ArrayList<>();
		usersRepository.findAll().forEach(e -> users.add(e));
		return users;
	}

	public Long deleteByUserUnum(Long userUnum) {
		return usersRepository.deleteByUserUnum(userUnum);
	}
}
