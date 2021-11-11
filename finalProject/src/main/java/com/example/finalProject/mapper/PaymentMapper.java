package com.example.finalProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.PaymentVO;

@Mapper
public interface PaymentMapper {
	public Long registPayment(PaymentVO paymentVO);
}
