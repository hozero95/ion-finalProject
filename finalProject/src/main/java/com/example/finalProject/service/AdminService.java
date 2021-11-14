package com.example.finalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.dto.Qna2DTO;
import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.domain.entity.QnaVO;
import com.example.finalProject.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	private AdminMapper adminMapper;

	public Long categoryAdd(CategoryVO categoryVO) {
		return adminMapper.categoryAdd(categoryVO);
	}

	public Long categoryDelete(Long categoryUnum) {
		return adminMapper.categoryDelete(categoryUnum);
	}

	public Long categoryUseorNot(CategoryVO categoryVO) {
		return adminMapper.categoryUseorNot(categoryVO);
	}

	public Long eventAdd(EventVO eventVO) {
		return adminMapper.eventAdd(eventVO);
	}

	public Long eventDelete(Long eventUnum) {
		return adminMapper.eventDelete(eventUnum);
	}

	public Long eventDateChange(EventVO eventVO) {
		return adminMapper.eventDateChange(eventVO);
	}

	public Long deliveryStatus(DeliveryVO deliveryVO) {
		return adminMapper.deliveryStatus(deliveryVO);
	}

	public Long deliveryStart(OrdersVO ordersVO) {
		return adminMapper.deliveryStart(ordersVO);
	}

	public Long productAdd(ProductVO productVO) {
		return adminMapper.productAdd(productVO);
	}

	public Long productDelete(Long productUnum) {
		return adminMapper.productDelete(productUnum);
	}

	public Long productInfoChange(ProductVO productVO) {
		return adminMapper.productInfoChange(productVO);
	}

	public Long qnareply(QnaVO qnaVO) {
		return adminMapper.qnareply(qnaVO);
	}

	public Long userDelete(Long userUnum) {
		return adminMapper.userDelete(userUnum);
	}

	public List<ProductVO> productAll() {
		return adminMapper.productAll();
	}

	public List<DeliveryVO> deliveryAll(){
		return adminMapper.deliveryAll();
	}
	public List<OrdersVO> orderAll(){
		return adminMapper.orderAll();
	}

	public List<Qna2DTO> qnaAll() {
		return adminMapper.qnaAll();
	}
	
	public List<EventVO> eventAll(){
		return adminMapper.eventAll();
	}
	
}
