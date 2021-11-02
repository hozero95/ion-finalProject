package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.OrdDelDTO;
import com.example.finalProject.domain.dto.OrdPayDelProDTO;
import com.example.finalProject.domain.dto.PayOrdRepProDTO;
import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.QnaVO;
import com.example.finalProject.domain.entity.ReplyVO;
import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.service.DeliveryService;
import com.example.finalProject.service.OrdDelService;
import com.example.finalProject.service.OrdPayDelProService;
import com.example.finalProject.service.OrdersService;
import com.example.finalProject.service.PayOrdRepProService;
import com.example.finalProject.service.QnaService;
import com.example.finalProject.service.ReplyService;
import com.example.finalProject.service.UsersService;

@RequestMapping("/api/mypage")
@RestController
public class MypageController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private OrdPayDelProService ordPayDelProService;
	@Autowired
	private OrdDelService ordDelService;
	@Autowired
	private PayOrdRepProService payOrdRepProService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private OrdersService ordersService;

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

	@GetMapping(value = "/show/ordercancel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdDelDTO>> showOrderCancel(@RequestParam Long userUnum) {
		List<OrdDelDTO> ordDelDTOs = ordDelService.showOrderCancel(userUnum);
		return new ResponseEntity<List<OrdDelDTO>>(ordDelDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/show/orderchange", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdDelDTO>> showOrderChange(@RequestParam Long userUnum) {
		List<OrdDelDTO> ordDelDTOs = ordDelService.showOrderChange(userUnum);
		return new ResponseEntity<List<OrdDelDTO>>(ordDelDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/show/orderreturn", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdDelDTO>> showOrderReturn(@RequestParam Long userUnum) {
		List<OrdDelDTO> ordDelDTOs = ordDelService.showOrderReturn(userUnum);
		return new ResponseEntity<List<OrdDelDTO>>(ordDelDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/show/reply/unregister", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PayOrdRepProDTO>> unregistReply(@RequestParam Long userUnum) {
		List<PayOrdRepProDTO> payOrdRepProDTOs = payOrdRepProService.unregistReply(userUnum);
		return new ResponseEntity<List<PayOrdRepProDTO>>(payOrdRepProDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/show/reply/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PayOrdRepProDTO>> registReply(@RequestParam Long userUnum,
			@RequestParam String replyStartDate, @RequestParam String replyEndDate) {
		List<PayOrdRepProDTO> payOrdRepProDTOs = payOrdRepProService.registReply(userUnum, replyStartDate,
				replyEndDate);
		return new ResponseEntity<List<PayOrdRepProDTO>>(payOrdRepProDTOs, HttpStatus.OK);
	}

	@DeleteMapping(value = "/remove/user", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeUser(@RequestParam Long userUnum) {
		return usersService.deleteByUserUnum(userUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/remove/order", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> removeOrder(@RequestParam Long orderUnum) {
		return deliveryService.deleteByOrderUnum(orderUnum) > 0 && ordersService.replaceOrder(orderUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PostMapping(value = "/regist/reply", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registReply(@RequestBody ReplyVO replyVO) {
		return replyService.registReply(replyVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PostMapping(value = "/regist/qna", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> registReply(@RequestBody QnaVO qnaVO) {
		return qnaService.registQna(qnaVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/orderchange", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceDeliveryChange(@RequestBody DeliveryVO deliveryVO) {
		return deliveryService.replaceDeliveryChange(deliveryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/orderreturn", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceOrderReturn(@RequestBody DeliveryVO deliveryVO) {
		return deliveryService.replaceDeliveryChange(deliveryVO) > 0 && ordersService.replaceOrderReturn(deliveryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/reply", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceReply(@RequestBody ReplyVO replyVO) {
		return replyService.replaceReply(replyVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/password", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replacePassword(@RequestBody UsersVO usersVO) {
		return usersService.replacePassword(usersVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
	@PatchMapping(value = "/replace/userinfo", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> replaceUserInfo(@RequestBody UsersVO usersVO) {
		return usersService.replaceUserInfo(usersVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
}
