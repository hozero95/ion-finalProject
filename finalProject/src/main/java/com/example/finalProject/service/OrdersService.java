package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.mapper.OrdersMapper;
import com.example.finalProject.respository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrdersMapper ordersMapper;

	public List<OrdersVO> findAll() {
		List<OrdersVO> orders = new ArrayList<>();
		ordersRepository.findAll().forEach(e -> orders.add(e));
		return orders;
	}

	public Long replaceOrder(Long orderUnum) {
		return ordersMapper.replaceOrder(orderUnum);
	}

	public Long registOrder(OrdersVO ordersVO) {
		ordersVO.setOrderRegdate(new Date());
		return ordersMapper.registOrder(ordersVO);
	}
	
	public Long replaceOrderReturn(DeliveryVO deliveryVO) {
		return ordersMapper.replaceOrderReturn(deliveryVO);
	}
	
	public Long recentOrderUnum(Long userUnum) {
		return ordersMapper.recentOrderUnum(userUnum).getOrderUnum();
	}
}
