package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.dto.Qna2DTO;
import com.example.finalProject.domain.entity.QnaVO;

@Mapper
public interface QnaMapper {
	public Long registQna(QnaVO qnaVO);
	
	public List<Qna2DTO> showQna(Long userUnum);
}
