package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.TestDTO;
import com.example.finalProject.api.domain.ProductVO;
import com.example.finalProject.api.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;

	public List<ProductVO> getAllProducts() {
		return testMapper.selectTest();
	}

	public List<TestDTO> showCountList(String categoryCode) {
		return testMapper.showCountList(categoryCode);
	}
}
