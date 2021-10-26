package com.example.finalProject.api.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.api.domain.ProductVO;

@Repository
public interface ProductRepository extends JpaRepository<ProductVO, Long> {
	/*
	 * select *
	 *   from product;
	 */
	public List<ProductVO> findAll();

	/* 
	 * 메인화면 - 검색
	 * 
	 * select *
	 *   from product
	 *  where product_name like '%{{product_name}}%'
	 *  order by product_name;
	 */
	public List<ProductVO> findByProductNameContaining(String productName, Sort sort);
	
	/*
	 * 상품리스트화면 - 리스트
	 * 
	 * select *
	 *   from product
	 *  where category_code = {{category_code}}
	 *  order by product_regdate desc, product_name;
	 */
	public List<ProductVO> findByCategoryCode(String CategoryCode, Sort sort);
}
