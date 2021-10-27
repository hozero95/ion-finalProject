package com.example.finalProject.api.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.PayRepDTO;

@Mapper
public interface PayRepMapper {
	List<PayRepDTO> unregistReply(Long userUnum);

	List<PayRepDTO> registReply(Long userUnum, Date replyStartDate, Date replyEndDate);
}
