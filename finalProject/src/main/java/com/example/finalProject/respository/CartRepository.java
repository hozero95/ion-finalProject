package com.example.finalProject.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.CartVO;

@Repository
public interface CartRepository extends JpaRepository<CartVO, Long> {
	public List<CartVO> findAll();

	@Transactional
	public Long deleteByUserUnumAndProductUnum(Long userUnum, Long productUnum);
}
