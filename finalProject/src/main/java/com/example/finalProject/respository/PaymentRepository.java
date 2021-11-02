package com.example.finalProject.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.PaymentVO;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentVO, Long> {
	public List<PaymentVO> findAll();
}
