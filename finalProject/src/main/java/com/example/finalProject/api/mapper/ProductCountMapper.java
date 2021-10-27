package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.ProductCountDTO;

@Mapper
public interface ProductCountMapper {
	List<ProductCountDTO> showBestProduct(String categoryCode);

	List<ProductCountDTO> showManyReplyProduct(String categoryCode);
}
