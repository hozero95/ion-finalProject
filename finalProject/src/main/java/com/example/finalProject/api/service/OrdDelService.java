package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.OrdDelDTO;
import com.example.finalProject.api.mapper.OrdDelMapper;

@Service
public class OrdDelService {
	@Autowired
	private OrdDelMapper ordDelMapper;

	public List<OrdDelDTO> showOrderCancel(Long userUnum) {
		return ordDelMapper.showOrderCancel(userUnum);
	}

	public List<OrdDelDTO> showOrderChange(Long userUnum) {
		return ordDelMapper.showOrderChange(userUnum);
	}

	public List<OrdDelDTO> showOrderReturn(Long userUnum) {
		return ordDelMapper.showOrderReturn(userUnum);
	}
}
