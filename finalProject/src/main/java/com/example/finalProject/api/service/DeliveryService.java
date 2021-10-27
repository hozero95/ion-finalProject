package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.DeliveryVO;
import com.example.finalProject.api.repository.DeliveryRepository;

@Service
public class DeliveryService {
	@Autowired
	private DeliveryRepository deliveryRepository;

	public List<DeliveryVO> findAll() {
		List<DeliveryVO> delivery = new ArrayList<>();
		deliveryRepository.findAll().forEach(e -> delivery.add(e));
		return delivery;
	}

	public Long deleteByOrderUnum(Long orderUnum) {
		return deliveryRepository.deleteByOrderUnum(orderUnum);
	}
}
