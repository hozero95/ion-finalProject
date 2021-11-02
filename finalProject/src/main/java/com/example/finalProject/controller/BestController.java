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

import com.example.finalProject.domain.dto.ProductCountDTO;
import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.ProductCountService;

@RequestMapping("/api/best")
@RestController
public class BestController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductCountService productCountService;

	@GetMapping(value = "/show/nav", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryVO>> bestShowNav() {
		List<CategoryVO> category = categoryService.bestshowNav();
		return new ResponseEntity<List<CategoryVO>>(category, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductCountDTO>> showBestProduct(@RequestParam String categoryCode) {
		List<ProductCountDTO> productCountDTOs = productCountService.showBestProduct(categoryCode);
		return new ResponseEntity<List<ProductCountDTO>>(productCountDTOs, HttpStatus.OK);
	}
}
