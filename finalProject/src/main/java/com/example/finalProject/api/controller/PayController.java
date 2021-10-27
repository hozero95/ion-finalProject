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

import com.example.finalProject.api.domain.CarUseProDTO;
import com.example.finalProject.api.service.CarUseProService;

@RequestMapping("/api/pay")
@RestController
public class PayController {
	@Autowired
	private CarUseProService carUseService;

	@GetMapping(value = "/show/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarUseProDTO>> showPayOrder(@RequestParam Long userUnum) {
		List<CarUseProDTO> carUseProDTOs = carUseService.showPayOrder(userUnum);
		return new ResponseEntity<List<CarUseProDTO>>(carUseProDTOs, HttpStatus.OK);
	}
}
