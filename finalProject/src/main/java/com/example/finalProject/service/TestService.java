package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.TestDTO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;

	public List<ProductVO> getAllProducts() {
		return testMapper.selectTest();
	}

	public List<TestDTO> showCountList(Long categoryUnum) {
		return testMapper.showCountList(categoryUnum);
	}
}
