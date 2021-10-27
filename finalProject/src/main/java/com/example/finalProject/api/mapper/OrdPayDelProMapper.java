package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.OrdPayDelProDTO;

@Mapper
public interface OrdPayDelProMapper {
	List<OrdPayDelProDTO> showOrderDeliveryThreeMonth(Long userUnum);

	List<OrdPayDelProDTO> showOrderDeliveryAll(Long userUnum);

	List<OrdPayDelProDTO> showDetailOrder(Long orderUnum);
}
