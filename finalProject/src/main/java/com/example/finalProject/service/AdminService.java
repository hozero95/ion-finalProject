package com.example.finalProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;
	
	public Long categoryAdd(CategoryVO categoryVO) {
		return adminMapper.categoryAdd(categoryVO);
	}
}
