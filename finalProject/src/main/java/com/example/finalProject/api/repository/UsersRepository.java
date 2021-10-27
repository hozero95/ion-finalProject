package com.example.finalProject.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Long> {
	public List<UsersVO> findAll();
	
	@Transactional
	public Long deleteByUserUnum(Long userUnum);
}
