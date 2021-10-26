package com.example.finalProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.api.domain.CategoryVO;
import com.example.finalProject.api.service.CategoryService;

@RequestMapping("/api/best")
@RestController
public class BestController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/show/nav", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryVO>> bestShowNav() {
		List<CategoryVO> category = categoryService.bestshowNav();
		return new ResponseEntity<List<CategoryVO>>(category, HttpStatus.OK);
	}
}
