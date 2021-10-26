package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.QnaVO;

@Repository
public interface QnaRepository extends JpaRepository<QnaVO, Long> {
	public List<QnaVO> findAll();
}
