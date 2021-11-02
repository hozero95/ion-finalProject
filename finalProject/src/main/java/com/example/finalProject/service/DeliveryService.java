package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.mapper.DeliveryMapper;
import com.example.finalProject.respository.DeliveryRepository;

@Service
public class DeliveryService {
	@Autowired
	private DeliveryRepository deliveryRepository;
	@Autowired
	private DeliveryMapper deliveryMapper;

	public List<DeliveryVO> findAll() {
		List<DeliveryVO> delivery = new ArrayList<>();
		deliveryRepository.findAll().forEach(e -> delivery.add(e));
		return delivery;
	}

	public Long deleteByOrderUnum(Long orderUnum) {
		return deliveryRepository.deleteByOrderUnum(orderUnum);
	}

	public Long replaceDeliveryStatus(DeliveryVO deliveryVO) {
		return deliveryMapper.replaceDeliveryStatus(deliveryVO);
	}
}
