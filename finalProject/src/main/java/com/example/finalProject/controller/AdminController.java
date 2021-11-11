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

import com.example.finalProject.domain.dto.OrdPayDelProDTO;
import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.domain.entity.QnaVO;
import com.example.finalProject.domain.entity.UsersVO;
import com.example.finalProject.service.AdminService;
import com.example.finalProject.service.UsersService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UsersService usersService;

	@PostMapping(value = "/category/add", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> categoryAdd(@RequestBody CategoryVO categoryVO) {
		System.out.println(categoryVO.getCategoryRef());
		return adminService.categoryAdd(categoryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@DeleteMapping(value = "/category/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> categoryDelete(@RequestParam Long categoryUnum) {
		return adminService.categoryDelete(categoryUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PatchMapping(value = "/category/useornot", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> categoryUseorNot(@RequestBody CategoryVO categoryVO) {
		return adminService.categoryUseorNot(categoryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PostMapping(value = "/event/add", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eventAdd(@RequestBody EventVO eventVO) {
		return adminService.eventAdd(eventVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@DeleteMapping(value = "/event/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eventDelete(@RequestParam Long eventUnum) {
		return adminService.eventDelete(eventUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PatchMapping(value = "/event/datechange", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> eventDateChange(@RequestBody EventVO eventVO) {
		return adminService.eventDateChange(eventVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PatchMapping(value = "/deliverystatus", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deliveryStatus(@RequestBody DeliveryVO deliveryVO) {
		return adminService.deliveryStatus(deliveryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PatchMapping(value = "/orderstatus", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> orderStatus(@RequestBody OrdersVO ordersVO) {
		return adminService.orderStatus(ordersVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PostMapping(value = "/product/add", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> productAdd(@RequestBody ProductVO productVO) {
		return adminService.productAdd(productVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@DeleteMapping(value = "/product/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> productDelete(@RequestParam Long productUnum) {
		return adminService.productDelete(productUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PatchMapping(value = "/product/infochange", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> productInfoChange(@RequestBody ProductVO productVO) {
		return adminService.productInfoChange(productVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@PostMapping(value = "/qnareply", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> qnareply(@RequestBody QnaVO qnaVO) {
		return adminService.qnareply(qnaVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@DeleteMapping(value = "/user/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> userDelete(@RequestParam Long userUnum) {
		return adminService.userDelete(userUnum) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.OK);
	}

	@GetMapping(value = "/product/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductVO>> productAll() {
		List<ProductVO> productall = adminService.productAll();
		return new ResponseEntity<List<ProductVO>>(productall, HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsersVO>> getUserAll() {
		List<UsersVO> userAll = usersService.getUserAll();
		return new ResponseEntity<List<UsersVO>>(userAll, HttpStatus.OK);
	}
	
	@GetMapping(value = "/orderdelivery/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrdPayDelProDTO>> orderDeliveryAll(){
		List<OrdPayDelProDTO> orderDeliveryAll = adminService.orderDeliveryAll();
		return new ResponseEntity<List<OrdPayDelProDTO>>(orderDeliveryAll, HttpStatus.OK);
	}
}
