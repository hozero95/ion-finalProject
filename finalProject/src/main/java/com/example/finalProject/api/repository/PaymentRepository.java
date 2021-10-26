package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.PaymentVO;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentVO, Long> {
	public List<PaymentVO> findAll();
}
