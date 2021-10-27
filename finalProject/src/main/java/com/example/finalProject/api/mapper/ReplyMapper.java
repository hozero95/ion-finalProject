package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.ReplyVO;

@Mapper
public interface ReplyMapper {
	public Long registReply(ReplyVO replyVO);
	
	@Transactional
	public Long replaceReply(ReplyVO replyVO);
}
