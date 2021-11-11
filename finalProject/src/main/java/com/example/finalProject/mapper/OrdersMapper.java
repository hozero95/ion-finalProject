package com.example.finalProject.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.OrdersVO;

@Mapper
public interface OrdersMapper {
	@Transactional
	public Long replaceOrder(Long orderUnum);

	public Long registOrder(OrdersVO orderVo);
	
	@Transactional
	public Long replaceOrderReturn(DeliveryVO deliveryVO);
	
	public OrdersVO recentOrderUnum(Long userUnum);
}
