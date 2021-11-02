package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.dto.CarUseProDTO;

@Mapper
public interface CarUseProMapper {
	List<CarUseProDTO> showPayOrder(Long userUnum);

	List<CarUseProDTO> showCart(Long userUnum);
}
