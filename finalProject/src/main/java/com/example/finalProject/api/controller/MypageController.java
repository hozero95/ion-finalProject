package com.example.finalProject.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.api.domain.OrdPayDelProDTO;
import com.example.finalProject.api.domain.QnaVO;
import com.example.finalProject.api.domain.ReplyVO;
import com.example.finalProject.api.service.OrdPayDelProService;
import com.example.finalProject.api.service.QnaService;
import com.example.finalProject.api.service.ReplyService;

@RequestMapping("/api/mypage")
@RestController
public class MypageController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private OrdPayDelProService ordPayDelProService;

	@GetMapping(value = "/show/detail/reply", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> showDetailReply(@RequestParam Long replyUnum) {
		List<ReplyVO> reply = replyService.showDetailReply(replyUnum);
		return new ResponseEntity<List<ReplyVO>>(reply, HttpStatus.OK);
	}

	@GetMapping(value = "/show/qna", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QnaVO>> mypageShowQna(@RequestParam Long userUnum) {
		List<QnaVO> qna = qnaService.mypageShowQna(userUnum);
		return new ResponseEntity<List<QnaVO>>(qna, HttpStatus.OK);
	}

	@GetMapping(value = "/show/detail/qna", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QnaVO>> showDetailQna(@RequestParam Long qnaUnum) {
		List<QnaVO> qna = qnaService.showDetailQna(qnaUnum);
		return new ResponseEntity<List<QnaVO>>(qna, HttpStatus.OK);
	}

	@GetMapping(value = "/show/orderdelivery/threemonth", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdPayDelProDTO>> showOrderDeliveryThreeMonth(@RequestParam Long userUnum) {
		List<OrdPayDelProDTO> ordPayDelProDTOs = ordPayDelProService.showOrderDeliveryThreeMonth(userUnum);
		return new ResponseEntity<List<OrdPayDelProDTO>>(ordPayDelProDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/orderdelivery/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdPayDelProDTO>> showOrderDeliveryAll(@RequestParam Long userUnum) {
		List<OrdPayDelProDTO> ordPayDelProDTOs = ordPayDelProService.showOrderDeliveryAll(userUnum);
		return new ResponseEntity<List<OrdPayDelProDTO>>(ordPayDelProDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/show/detail/order", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdPayDelProDTO>> showDetailOrder(@RequestParam Long orderUnum) {
		List<OrdPayDelProDTO> ordPayDelProDTOs = ordPayDelProService.showDetailOrder(orderUnum);
		return new ResponseEntity<List<OrdPayDelProDTO>>(ordPayDelProDTOs, HttpStatus.OK);
	}
}
