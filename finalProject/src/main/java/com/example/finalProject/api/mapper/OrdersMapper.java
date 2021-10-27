package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.OrdersVO;

@Mapper
public interface OrdersMapper {
	@Transactional
	public Long replaceOrder(Long orderUnum);

	public Long registOrder(OrdersVO orderVo);
}
