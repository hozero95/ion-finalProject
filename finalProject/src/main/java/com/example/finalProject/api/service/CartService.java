package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.CartVO;
import com.example.finalProject.api.mapper.CartMapper;
import com.example.finalProject.api.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private CartMapper cartMapper;

	public List<CartVO> findAll() {
		List<CartVO> cart = new ArrayList<>();
		cartRepository.findAll().forEach(e -> cart.add(e));
		return cart;
	}

	public Long deleteByUserUnumAndProductUnum(Long userUnum, Long productUnum) {
		return cartRepository.deleteByUserUnumAndProductUnum(userUnum, productUnum);
	}
	
	public Long registCart(CartVO cartVO) {
		return cartMapper.registCart(cartVO);
	}
	
	public Long replaceCount(CartVO cartVO) {
		return cartMapper.replaceCount(cartVO);
	}
	
	public Long replaceAddress(CartVO cartVO) {
		return cartMapper.replaceAddress(cartVO);
	}
}
