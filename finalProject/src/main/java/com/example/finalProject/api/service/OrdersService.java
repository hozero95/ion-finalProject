package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.OrdersVO;
import com.example.finalProject.api.mapper.OrdersMapper;
import com.example.finalProject.api.repository.OrdersRepository;

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
		return ordersMapper.registOrder(ordersVO);
	}
}
