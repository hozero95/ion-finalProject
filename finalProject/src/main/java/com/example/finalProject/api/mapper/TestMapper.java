package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.ProductVO;
import com.example.finalProject.api.domain.TestDTO;

@Mapper
public interface TestMapper {
	List<ProductVO> selectTest();
	
	List<TestDTO> showCountList(String categoryCode);
}
