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

import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.service.EventService;
import com.example.finalProject.service.ProductService;

@RequestMapping("/api/season")
@RestController
public class SeasonController {
	@Autowired
	private ProductService productService;
	@Autowired
	private EventService eventService;

	@GetMapping(value = "/show/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> seasonShowProduct(@RequestParam Long productSeason) {
		List<ProductVO> product = productService.seasonShowProduct(productSeason);
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/show/eventimage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventVO>> seasonShowEventImage(@RequestParam Long eventUnum) {
		List<EventVO> event = eventService.seasonShowEventImage(eventUnum);
		return new ResponseEntity<List<EventVO>>(event, HttpStatus.OK);
	}
}
