package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.CarUseProDTO;

@Mapper
public interface CarUseProMapper {
	List<CarUseProDTO> showPayOrder(Long userUnum);
}
