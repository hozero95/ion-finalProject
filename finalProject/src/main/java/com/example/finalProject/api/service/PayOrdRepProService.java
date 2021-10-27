package com.example.finalProject.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.PayOrdRepProDTO;
import com.example.finalProject.api.mapper.PayOrdRepProMapper;

@Service
public class PayOrdRepProService {
	@Autowired
	private PayOrdRepProMapper payRepMapper;

	public List<PayOrdRepProDTO> unregistReply(Long userUnum) {
		return payRepMapper.unregistReply(userUnum);
	}

	public List<PayOrdRepProDTO> registReply(Long userUnum, String replyStartDate, String replyEndDate) {
		return payRepMapper.registReply(userUnum, replyStartDate, replyEndDate);
	}
}
