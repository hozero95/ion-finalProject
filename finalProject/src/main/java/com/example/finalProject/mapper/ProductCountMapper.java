package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.dto.ProductCountDTO;

@Mapper
public interface ProductCountMapper {
	List<ProductCountDTO> showBestProduct(Long categoryUnum);

	List<ProductCountDTO> showManyReplyProduct(Long categoryUnum);
}
