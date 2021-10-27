package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.PayOrdRepProDTO;

@Mapper
public interface PayOrdRepProMapper {
	List<PayOrdRepProDTO> unregistReply(Long userUnum);

	List<PayOrdRepProDTO> registReply(Long userUnum, String replyStartDate, String replyEndDate);
}
