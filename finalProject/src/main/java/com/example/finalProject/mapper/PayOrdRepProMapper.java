package com.example.finalProject.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.dto.PayOrdRepProDTO;

@Mapper
public interface PayOrdRepProMapper {
	List<PayOrdRepProDTO> unregistReply(Long userUnum);

	List<PayOrdRepProDTO> registReply(Long userUnum, String replyStartDate, String replyEndDate);
}
