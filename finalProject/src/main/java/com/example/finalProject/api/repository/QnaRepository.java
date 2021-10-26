package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.QnaVO;

@Repository
public interface QnaRepository extends JpaRepository<QnaVO, Long> {
	public List<QnaVO> findAll();
	
	/*
	 * 마이페이지 - Q&A 리스트 불러오기
	 * select *
 	 *	 from qna
 	 *	where user_unum = {{user_unum}}
	 *	order by qna_regdate desc;
	 */
	public List<QnaVO> findByUserUnumOrderByDesc(Long userUnum);
}
