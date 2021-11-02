package com.example.finalProject.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.EventVO;

@Repository
public interface EventRepository extends JpaRepository<EventVO, Long> {
	public List<EventVO> findAll();
	
	/* 메인화면 - slide 이벤트 불러오기, 
	   이벤트화면 - 이벤트 목록 불러오기
	 * select *
	 *	 from event
	 *	where event_enddate is null
	 *	   or event_enddate > sysdate
	 *	order by event_regdate desc, event_enddate, event_title;
	 */
	public List<EventVO> findByEventEnddateIsNullOrEventEnddateGreaterThan(Date date, Sort sort);

	/* 제철상품화면 - 이벤트이미지불러오기
	 * select *
	 *	 from event
	 *  where event_unum = {{event_unum}};
	 */
	public List<EventVO> findByEventUnum(Long eventUnum);
}