package com.example.finalProject.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.CategoryVO;

@Mapper
public interface AdminMapper {
	public Long categoryAdd(CategoryVO categoryVO);
}
