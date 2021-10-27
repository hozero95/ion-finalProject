package com.example.finalProject.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.CartVO;

@Repository
public interface CartRepository extends JpaRepository<CartVO, Long> {
	public List<CartVO> findAll();

	@Transactional
	public Long deleteByUserUnumAndProductUnum(Long userUnum, Long productUnum);
}
