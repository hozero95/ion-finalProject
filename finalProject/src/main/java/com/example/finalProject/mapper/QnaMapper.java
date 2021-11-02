package com.example.finalProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.QnaVO;

@Mapper
public interface QnaMapper {
	public Long registQna(QnaVO qnaVO);
}
