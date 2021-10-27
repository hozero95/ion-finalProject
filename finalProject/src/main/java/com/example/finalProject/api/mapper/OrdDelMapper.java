package com.example.finalProject.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.OrdDelDTO;

@Mapper
public interface OrdDelMapper {
	List<OrdDelDTO> showOrderCancel(Long userUnum);

	List<OrdDelDTO> showOrderChange(Long userUnum);

	List<OrdDelDTO> showOrderReturn(Long userUnum);
}
