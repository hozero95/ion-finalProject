package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.CartVO;
import com.example.finalProject.api.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	public List<CartVO> findAll() {
		List<CartVO> cart = new ArrayList<>();
		cartRepository.findAll().forEach(e -> cart.add(e));
		return cart;
	}

	public Long deleteByUserUnumAndProductUnum(Long userUnum, Long productUnum) {
		return cartRepository.deleteByUserUnumAndProductUnum(userUnum, productUnum);
	}
}
