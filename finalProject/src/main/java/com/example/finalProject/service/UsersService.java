package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.mapper.UsersMapper;
import com.example.finalProject.respository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersMapper usersMapper;

	public List<UsersVO> findAll() {
		List<UsersVO> users = new ArrayList<>();
		usersRepository.findAll().forEach(e -> users.add(e));
		return users;
	}

	public Long deleteByUserUnum(Long userUnum) {
		return usersRepository.deleteByUserUnum(userUnum);
	}

	public Long replacePassword(UsersVO usersVO) {
		return usersMapper.replacePassword(usersVO);
	}

	public Long replaceUserInfo(UsersVO usersVO) {
		return usersMapper.replaceUserInfo(usersVO);
	}
}
