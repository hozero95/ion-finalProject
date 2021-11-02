package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.OrdPayDelProDTO;
import com.example.finalProject.mapper.OrdPayDelProMapper;

@Service
public class OrdPayDelProService {
	@Autowired
	private OrdPayDelProMapper ordPayDelProMapper;

	public List<OrdPayDelProDTO> showOrderDeliveryThreeMonth(Long userUnum) {
		return ordPayDelProMapper.showOrderDeliveryThreeMonth(userUnum);
	}

	public List<OrdPayDelProDTO> showOrderDeliveryAll(Long userUnum) {
		return ordPayDelProMapper.showOrderDeliveryAll(userUnum);
	}

	public List<OrdPayDelProDTO> showDetailOrder(Long orderUnum) {
		return ordPayDelProMapper.showDetailOrder(orderUnum);
	}
}
