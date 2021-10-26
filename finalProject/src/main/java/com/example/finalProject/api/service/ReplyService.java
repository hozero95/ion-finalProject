package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.ReplyVO;
import com.example.finalProject.api.repository.ReplyRepository;

@Service
public class ReplyService {
	@Autowired
	private ReplyRepository replyRepository;

	public List<ReplyVO> findAll() {
		List<ReplyVO> reply = new ArrayList<>();
		replyRepository.findAll().forEach(e -> reply.add(e));
		return reply;
	}
}
