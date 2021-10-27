package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.CartVO;

@Mapper
public interface CartMapper {
	public Long registCart(CartVO cartVO);
	
	@Transactional
	public Long replaceCount(CartVO cartVO);
	
	@Transactional
	public Long replaceAddress(CartVO cartVO);
}
