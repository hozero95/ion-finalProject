package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.CategoryVO;
import com.example.finalProject.api.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryVO> findAll() {
		List<CategoryVO> category = new ArrayList<>();
		categoryRepository.findAll().forEach(e -> category.add(e));
		return category;
	}
}