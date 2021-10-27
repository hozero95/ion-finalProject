package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.ProductCountDTO;
import com.example.finalProject.api.mapper.ProductCountMapper;

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
