package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.ProductCountDTO;
import com.example.finalProject.mapper.ProductCountMapper;

@Service
public class ProductCountService {
	@Autowired
	ProductCountMapper productCountMapper;

	public List<ProductCountDTO> showBestProduct(Long categoryUnum) {
		return productCountMapper.showBestProduct(categoryUnum);
	}

	public List<ProductCountDTO> showManyReplyProduct(Long categoryUnum) {
		return productCountMapper.showManyReplyProduct(categoryUnum);
	}
}
