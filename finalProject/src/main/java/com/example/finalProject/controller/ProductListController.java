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
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.service.ProductCountService;
import com.example.finalProject.service.ProductService;

@RequestMapping("/api/productlist")
@RestController
public class ProductListController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCountService productCountService;

	@GetMapping(value = "/show/product/new", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductNew(@RequestParam Long categoryUnum) {
		List<ProductVO> product = productService.findByCategoryCode(categoryUnum, "new");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/lowerprice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductLowerprice(@RequestParam Long categoryUnum) {
		List<ProductVO> product = productService.findByCategoryCode(categoryUnum, "lowerprice");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/higherprice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductHigherprice(@RequestParam Long categoryUnum) {
		List<ProductVO> product = productService.findByCategoryCode(categoryUnum, "higherprice");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/manyreply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductCountDTO>> showManyReplyProduct(@RequestParam Long categoryUnum) {
		List<ProductCountDTO> productCountDTOs = productCountService.showManyReplyProduct(categoryUnum);
		return new ResponseEntity<List<ProductCountDTO>>(productCountDTOs, HttpStatus.OK);
	}
}
