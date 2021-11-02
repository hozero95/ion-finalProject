package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.PayOrdRepProDTO;
import com.example.finalProject.mapper.PayOrdRepProMapper;

@Service
public class PayOrdRepProService {
	@Autowired
	private PayOrdRepProMapper payRepMapper;

	public List<PayOrdRepProDTO> unregistReply(Long userUnum) {
		return payRepMapper.unregistReply(userUnum);
	}

	public List<PayOrdRepProDTO> registReply(Long userUnum, String replyStartDate, String replyEndDate) {
//		Date replyStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
//		Date replyEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		return payRepMapper.registReply(userUnum, replyStartDate, replyEndDate);
	}
}
