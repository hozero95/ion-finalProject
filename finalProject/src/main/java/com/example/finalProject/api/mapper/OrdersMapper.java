package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {
	@Transactional
	public Long replaceOrder(Long orderUnum);
}
