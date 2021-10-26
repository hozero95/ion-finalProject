package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.ProductVO;
import com.example.finalProject.api.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public List<ProductVO> findAll() {
		List<ProductVO> product = new ArrayList<>();
		productRepository.findAll().forEach(e -> product.add(e));
		return product;
	}

	public List<ProductVO> findByProductNameContaining(String productName) {
		List<ProductVO> product = new ArrayList<>();
		Sort sort = Sort.by("productName");
		productRepository.findByProductNameContaining(productName, sort).forEach(e -> product.add(e));
		return product;
	}

	public List<ProductVO> findByCategoryCode(String categoryCode, String sortCase) {
		List<ProductVO> product = new ArrayList<>();
		Sort sort = Sort.by("productName");
		if (sortCase.equals("new")) {
			sort = Sort.by("productRegdate").descending().and(Sort.by("productName"));
		} else if (sortCase.equals("lowerprice")) {
			sort = Sort.by("productPrice").and(Sort.by("productName"));
		} else if (sortCase.equals("higherprice")) {
			sort = Sort.by("productPrice").descending().and(Sort.by("productName"));
		}
		productRepository.findByCategoryCode(categoryCode, sort).forEach(e -> product.add(e));
		return product;
	}
}
