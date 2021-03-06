package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.PaymentVO;
import com.example.finalProject.mapper.PaymentMapper;
import com.example.finalProject.respository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentMapper paymentMapper;

	public List<PaymentVO> findAll() {
		List<PaymentVO> payment = new ArrayList<>();
		paymentRepository.findAll().forEach(e -> payment.add(e));
		return payment;
	}

	public Long registPayment(PaymentVO paymentVO) {
		return paymentMapper.registPayment(paymentVO);
	}
}
