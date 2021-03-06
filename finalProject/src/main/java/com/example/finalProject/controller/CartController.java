package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.CarUseProDTO;
import com.example.finalProject.domain.entity.CartVO;
import com.example.finalProject.service.CarUseProService;
import com.example.finalProject.service.CartService;

@RequestMapping("/api/cart")
@RestController
public class CartController {
	@Autowired
	private CarUseProService cartUseProService;
	@Autowired
	private CartService cartService;

	@GetMapping(value = "/show/cart", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarUseProDTO>> showCart(@RequestParam Long userUnum) {
		List<CarUseProDTO> carUseProDTOs = cartUseProService.showCart(userUnum);
		return new ResponseEntity<List<CarUseProDTO>>(carUseProDTOs, HttpStatus.OK);
	}

	@DeleteMapping(value = "/remove/cart", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeCart(@RequestParam Long userUnum, @RequestParam Long productUnum) {
		return cartService.deleteByUserUnumAndProductUnum(userUnum, productUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/count", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceCount(@RequestBody CartVO cartVO) {
		return cartService.replaceCount(cartVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/address", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceAddress(@RequestBody CartVO cartVO) {
		return cartService.replaceAddress(cartVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
}
