package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.CarUseProDTO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.service.CarUseProService;
import com.example.finalProject.service.OrdersService;

@RequestMapping("/api/pay")
@RestController
public class PayController {
	@Autowired
	private CarUseProService carUseService;
	@Autowired
	private OrdersService ordersService;

	@GetMapping(value = "/show/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarUseProDTO>> showPayOrder(@RequestParam Long userUnum) {
		List<CarUseProDTO> carUseProDTOs = carUseService.showPayOrder(userUnum);
		return new ResponseEntity<List<CarUseProDTO>>(carUseProDTOs, HttpStatus.OK);
	}
	
	@PostMapping(value = "/regist/order", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registOrder(@RequestBody OrdersVO ordersVO) {
		return ordersService.registOrder(ordersVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);	
	}
}
