package com.example.finalProject.controller;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.CarUseProDTO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.domain.entity.PaymentVO;
import com.example.finalProject.service.CarUseProService;
import com.example.finalProject.service.CartService;
import com.example.finalProject.service.OrdersService;
import com.example.finalProject.service.PaymentService;

@RequestMapping("/api/pay")
@RestController
public class PayController {
	@Autowired
	private CarUseProService carUseService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private CartService cartService;

	@GetMapping(value = "/show/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarUseProDTO>> showPayOrder(@RequestParam Long userUnum) {
		List<CarUseProDTO> carUseProDTOs = carUseService.showPayOrder(userUnum);
		return new ResponseEntity<List<CarUseProDTO>>(carUseProDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/show/recentOrder")
	public ResponseEntity<Long> recentOrderUnum(@RequestParam Long userUnum) {
		return new ResponseEntity<Long>(ordersService.recentOrderUnum(userUnum), HttpStatus.OK);
	}

	@PostMapping(value = "/regist/order", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registOrder(@RequestBody OrdersVO ordersVO) {
		return ordersService.registOrder(ordersVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PostMapping(value = "/regist/payment", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registPayment(@RequestBody PaymentVO paymentVO) {
		return paymentService.registPayment(paymentVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/trash/cart", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> trashCart(@RequestParam Long userUnum) {
		return cartService.trashCart(userUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}
}
