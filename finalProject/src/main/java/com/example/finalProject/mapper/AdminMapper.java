package com.example.finalProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.domain.entity.DeliveryVO;
import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.domain.entity.OrdersVO;
import com.example.finalProject.domain.entity.ProductVO;
import com.example.finalProject.domain.entity.QnaVO;

@Mapper
public interface AdminMapper {
	public Long categoryAdd(CategoryVO categoryVO);

	public Long categoryDelete(Long categoryUnum);

	public Long categoryUseorNot(CategoryVO categoryVO);

	public Long eventAdd(EventVO eventVO);

	public Long eventDelete(Long eventUnum);

	public Long eventDateChange(EventVO eventVO);

	public Long deliveryStatus(DeliveryVO deliveryVO);

	public Long orderStatus(OrdersVO ordersVO);

	public Long productAdd(ProductVO productVO);

	public Long productDelete(Long productUnum);

	public Long productInfoChange(ProductVO productVO);

	public Long qnareply(QnaVO qnaVO);

	public Long userDelete(Long userUnum);
	
	public List<ProductVO> productAll();

}
