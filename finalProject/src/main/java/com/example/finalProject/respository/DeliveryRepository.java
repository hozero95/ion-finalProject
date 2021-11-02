package com.example.finalProject.respository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.DeliveryVO;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryVO, Long> {
	public List<DeliveryVO> findAll();

	@Transactional
	public Long deleteByOrderUnum(Long orderUnum);
}
