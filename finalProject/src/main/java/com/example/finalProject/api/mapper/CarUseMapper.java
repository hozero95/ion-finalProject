package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.CarUseDTO;

@Mapper
public interface CarUseMapper {
	List<CarUseDTO> showPayOrder(Long userUnum);
}
