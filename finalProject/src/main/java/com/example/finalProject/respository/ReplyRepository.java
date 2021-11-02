package com.example.finalProject.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.ReplyVO;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyVO, Long> {
	public List<ReplyVO> findAll();
	
	/*
	 * 마이페이지 - 작성한 리뷰 상세 조회
	 * select *
	 *	 from reply
	 *	where reply_unum = {{reply_unum}};
	 */
	public List<ReplyVO> findByReplyUnum(Long replyUnum);
}
