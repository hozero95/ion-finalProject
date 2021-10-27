package com.example.finalProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.api.domain.ProductCountDTO;
import com.example.finalProject.api.domain.ProductVO;
import com.example.finalProject.api.service.ProductCountService;
import com.example.finalProject.api.service.ProductService;

@RequestMapping("/api/productlist")
@RestController
public class ProductListController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCountService productCountService;

	@GetMapping(value = "/show/product/new", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductNew(@RequestParam String categoryCode) {
		List<ProductVO> product = productService.findByCategoryCode(categoryCode, "new");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/lowerprice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductLowerprice(@RequestParam String categoryCode) {
		List<ProductVO> product = productService.findByCategoryCode(categoryCode, "lowerprice");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/higherprice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> showProductHigherprice(@RequestParam String categoryCode) {
		List<ProductVO> product = productService.findByCategoryCode(categoryCode, "higherprice");
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/product/manyreply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductCountDTO>> showManyReplyProduct(@RequestParam String categoryCode) {
		List<ProductCountDTO> productCountDTOs = productCountService.showManyReplyProduct(categoryCode);
		return new ResponseEntity<List<ProductCountDTO>>(productCountDTOs, HttpStatus.OK);
	}
}
