package com.example.finalProject.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.DeliveryVO;

@Mapper
public interface DeliveryMapper {
	@Transactional
	public Long replaceDeliveryChange(DeliveryVO deliveryVO);
}
