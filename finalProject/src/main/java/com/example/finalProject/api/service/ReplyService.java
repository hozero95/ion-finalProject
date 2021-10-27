package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.ReplyVO;
import com.example.finalProject.api.mapper.ReplyMapper;
import com.example.finalProject.api.repository.ReplyRepository;

@Service
public class ReplyService {
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private ReplyMapper replyMapper;

	public List<ReplyVO> findAll() {
		List<ReplyVO> reply = new ArrayList<>();
		replyRepository.findAll().forEach(e -> reply.add(e));
		return reply;
	}

	public List<ReplyVO> showDetailReply(Long replyUnum) {
		List<ReplyVO> reply = new ArrayList<>();
		replyRepository.findByReplyUnum(replyUnum).forEach(e -> reply.add(e));
		return reply;
	}

	public Long registReply(ReplyVO replyVO) {
		return replyMapper.registReply(replyVO);
	}
	
	public Long replaceReply(ReplyVO replyVO) {
		return replyMapper.replaceReply(replyVO);
	}
}
