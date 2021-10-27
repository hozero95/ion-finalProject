package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.CarUseProDTO;
import com.example.finalProject.api.mapper.CarUseProMapper;

@Service
public class CarUseProService {
	@Autowired
	private CarUseProMapper carUseProMapper;

	public List<CarUseProDTO> showPayOrder(Long userUnum) {
		return carUseProMapper.showPayOrder(userUnum);
	}
}
