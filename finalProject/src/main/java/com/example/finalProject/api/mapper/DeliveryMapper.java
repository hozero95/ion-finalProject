package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.DeliveryVO;

@Mapper
public interface DeliveryMapper {
	@Transactional
	public Long replaceDeliveryStatus(DeliveryVO deliveryVO);
}
