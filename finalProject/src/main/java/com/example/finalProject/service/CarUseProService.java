package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.CarUseProDTO;
import com.example.finalProject.mapper.CarUseProMapper;

@Service
public class CarUseProService {
	@Autowired
	private CarUseProMapper carUseProMapper;

	public List<CarUseProDTO> showPayOrder(Long userUnum) {
		return carUseProMapper.showPayOrder(userUnum);
	}

	public List<CarUseProDTO> showCart(Long userUnum) {
		return carUseProMapper.showCart(userUnum);
	}
}
