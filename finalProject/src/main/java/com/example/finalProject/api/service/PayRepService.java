package com.example.finalProject.api.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.PayRepDTO;
import com.example.finalProject.api.mapper.PayRepMapper;

@Service
public class PayRepService {
	@Autowired
	private PayRepMapper payRepMapper;

	public List<PayRepDTO> unregistReply(Long userUnum) {
		return payRepMapper.unregistReply(userUnum);
	}

	public List<PayRepDTO> registReply(Long userUnum, Date replyStartDate, Date replyEndDate) {
		return payRepMapper.registReply(userUnum, replyStartDate, replyEndDate);
	}
}
