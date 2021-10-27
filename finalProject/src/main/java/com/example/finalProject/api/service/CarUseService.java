package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.CarUseDTO;
import com.example.finalProject.api.mapper.CarUseMapper;

@Service
public class CarUseService {
	@Autowired
	private CarUseMapper carUseMapper;

	public List<CarUseDTO> showPayOrder(Long userUnum) {
		return carUseMapper.showPayOrder(userUnum);
	}
}
