package com.example.finalProject.respository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.QnaVO;

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
	
	public List<QnaVO> findByUserUnumOrderByQnaRegdateDesc(Long userUnum);
	
	/*
	 * 마이페이지 - Q&A 상세 조회
	 * select *
	 *	 from qna
	 *	where qna_unum = {{qna_unum}};
	 */
	public List<QnaVO> findByQnaUnum(Long qnaUnum);
}
