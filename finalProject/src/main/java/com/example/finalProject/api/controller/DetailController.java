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

import com.example.finalProject.api.domain.ProductVO;
import com.example.finalProject.api.service.ProductService;

@RequestMapping("/api/detail")
@RestController
public class DetailController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/show/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> detailShowProduct(@RequestParam Long productUnum) {
		List<ProductVO> product = productService.detailShowProduct(productUnum);
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

}
