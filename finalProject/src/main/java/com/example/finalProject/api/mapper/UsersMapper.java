package com.example.finalProject.api.mapper;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.api.domain.UsersVO;

@Mapper
public interface UsersMapper {
	@Transactional
	public Long replacePassword(UsersVO usersVO);
	
	@Transactional
	public Long replaceUserInfo(UsersVO usersVO);
}
