package com.example.finalProject.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.DeliveryVO;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryVO, Long> {
	public List<DeliveryVO> findAll();

	@Transactional
	public Long deleteByOrderUnum(Long orderUnum);
}
