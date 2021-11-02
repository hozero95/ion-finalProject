package com.example.finalProject.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.ReplyVO;

@Mapper
public interface ReplyMapper {
	public Long registReply(ReplyVO replyVO);
	
	@Transactional
	public Long replaceReply(ReplyVO replyVO);
}
