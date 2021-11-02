package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.dto.TestDTO;
import com.example.finalProject.domain.entity.CartVO;
import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.domain.entity.PaymentVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.domain.entity.QnaVO;
import com.example.finalProject.domain.entity.ReplyVO;
import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.service.CartService;
import com.example.finalProject.service.CategoryService;
import com.example.finalProject.service.DeliveryService;
import com.example.finalProject.service.EventService;
import com.example.finalProject.service.OrdersService;
import com.example.finalProject.service.PaymentService;
import com.example.finalProject.service.ProductService;
import com.example.finalProject.service.QnaService;
import com.example.finalProject.service.ReplyService;
import com.example.finalProject.service.TestService;
import com.example.finalProject.service.UsersService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private UsersService usersService;
	@Autowired
	private ProductService productService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CartService cartService;
	@Autowired
	private TestService testService;

	@GetMapping(value = "/usersAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsersVO>> getUsersAll() {
		List<UsersVO> users = usersService.findAll();
		return new ResponseEntity<List<UsersVO>>(users, HttpStatus.OK);
	}

	@GetMapping(value = "/productAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> getProductAll() {
//		List<ProductVO> product = productService.findAll();
		List<ProductVO> product = testService.getAllProducts(); // MyBatis 사용
		return new ResponseEntity<List<ProductVO>>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/ordersAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdersVO>> getOrdersAll() {
		List<OrdersVO> orders = ordersService.findAll();
		return new ResponseEntity<List<OrdersVO>>(orders, HttpStatus.OK);
	}

	@GetMapping(value = "/paymentAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PaymentVO>> getPaymentAll() {
		List<PaymentVO> payment = paymentService.findAll();
		return new ResponseEntity<List<PaymentVO>>(payment, HttpStatus.OK);
	}

	@GetMapping(value = "/qnaAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<QnaVO>> getQnaAll() {
		List<QnaVO> qna = qnaService.findAll();
		return new ResponseEntity<List<QnaVO>>(qna, HttpStatus.OK);
	}

	@GetMapping(value = "/replyAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> getReplyAll() {
		List<ReplyVO> reply = replyService.findAll();
		return new ResponseEntity<List<ReplyVO>>(reply, HttpStatus.OK);
	}

	@GetMapping(value = "/categoryAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoryVO>> getCategoryAll() {
		List<CategoryVO> category = categoryService.findAll();
		return new ResponseEntity<List<CategoryVO>>(category, HttpStatus.OK);
	}

	@GetMapping(value = "/deliveryAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliveryVO>> getDeliveryAll() {
		List<DeliveryVO> delivery = deliveryService.findAll();
		return new ResponseEntity<List<DeliveryVO>>(delivery, HttpStatus.OK);
	}

	@GetMapping(value = "/eventAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventVO>> getEventAll() {
		List<EventVO> event = eventService.findAll();
		return new ResponseEntity<List<EventVO>>(event, HttpStatus.OK);
	}

	@GetMapping(value = "/cartAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CartVO>> getCartAll() {
		List<CartVO> cart = cartService.findAll();
		return new ResponseEntity<List<CartVO>>(cart, HttpStatus.OK);
	}

	@GetMapping(value = "/productCountList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestDTO>> showCountList(@RequestParam Long categoryUnum) {
		List<TestDTO> product = testService.showCountList(categoryUnum);
		return new ResponseEntity<List<TestDTO>>(product, HttpStatus.OK);
	}
	
	@GetMapping(value = "/testapi", produces = MediaType.TEXT_PLAIN_VALUE)
	@CrossOrigin(origins = {"http://localhost:8000"})
	public ResponseEntity<String> testapi() {
		return new ResponseEntity<String>("API TEST 중입니다.", HttpStatus.OK);
	}
}
