package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.dto.TestDTO;
import com.example.finalProject.domain.entity.ProductVO;

@Mapper
public interface TestMapper {
	List<ProductVO> selectTest();
	
	List<TestDTO> showCountList(String categoryCode);
}
