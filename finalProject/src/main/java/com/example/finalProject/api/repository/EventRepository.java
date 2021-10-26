package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.EventVO;

@Repository
public interface EventRepository extends JpaRepository<EventVO, Long> {
	public List<EventVO> findAll();
}