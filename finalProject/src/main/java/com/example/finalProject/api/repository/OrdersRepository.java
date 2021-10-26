package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.OrdersVO;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersVO, Long> {
	public List<OrdersVO> findAll();
}
