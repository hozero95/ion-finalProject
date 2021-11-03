package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.respository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryVO> findAll() {
		List<CategoryVO> category = new ArrayList<>();
		categoryRepository.findAll().forEach(e -> category.add(e));
		return category;
	}

	public List<CategoryVO> showNav() {
		List<CategoryVO> category = new ArrayList<>();
		categoryRepository.findByCategoryUsedIsNullOrCategoryUsed(0L).forEach(e -> category.add(e));
		return category;
	}

	public List<CategoryVO> bestshowNav() {
		List<CategoryVO> category = new ArrayList<>();
		categoryRepository.findByCategoryRefIsNullAndCategoryUsedIsNullOrCategoryUsed(0L).forEach(e -> category.add(e));
		return category;
	}
	
}