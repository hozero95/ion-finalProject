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

	public List<ProductCountDTO> showBestProduct(String categoryCode) {
		return productCountMapper.showBestProduct(categoryCode);
	}

	public List<ProductCountDTO> showManyReplyProduct(String categoryCode) {
		return productCountMapper.showManyReplyProduct(categoryCode);
	}
}
