package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.Qna2DTO;
import com.example.finalProject.domain.entity.QnaVO;
import com.example.finalProject.mapper.QnaMapper;
import com.example.finalProject.respository.QnaRepository;

@Service
public class QnaService {
	@Autowired
	private QnaRepository qnaRepository;
	@Autowired
	private QnaMapper qnaMapper;

	public List<QnaVO> findAll() {
		List<QnaVO> qna = new ArrayList<>();
		qnaRepository.findAll().forEach(e -> qna.add(e));
		return qna;
	}

	public List<QnaVO> mypageShowQna(Long userUnum) {
		List<QnaVO> qna = new ArrayList<>();
		qnaRepository.findByUserUnumOrderByQnaRegdateDesc(userUnum).forEach(e -> qna.add(e));
		return qna;
	}

	public List<QnaVO> showDetailQna(Long qnaUnum) {
		List<QnaVO> qna = new ArrayList<>();
		qnaRepository.findByQnaUnum(qnaUnum).forEach(e -> qna.add(e));
		return qna;
	}

	public Long registQna(QnaVO qnaVO) {
		return qnaMapper.registQna(qnaVO);
	}

	public List<Qna2DTO> showQna(Long userUnum) {
		List<Qna2DTO> qna = new ArrayList<>();
		qna = qnaMapper.showQna(userUnum);
		return qna;
	}
}
