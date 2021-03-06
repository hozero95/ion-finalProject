package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.ProductService;

@RequestMapping("/api/main")
@RestController
public class MainController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/show/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProduct(@RequestParam String productName) {
		List<ProductVO> product = productService.findByProductNameContaining(productName);
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/nav", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryVO>> showNav() {
		List<CategoryVO> category = categoryService.showNav();
		return new ResponseEntity<List<CategoryVO>>(category, HttpStatus.OK);
	}

}