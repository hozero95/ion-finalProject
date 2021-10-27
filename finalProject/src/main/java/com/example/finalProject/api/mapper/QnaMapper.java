package com.example.finalProject.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.QnaVO;

@Mapper
public interface QnaMapper {
	public Long registQna(QnaVO qnaVO);
}
