package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.CategoryVO;

@Mapper
public interface CategoryMapper {
	public List<CategoryVO> showNav();
}
