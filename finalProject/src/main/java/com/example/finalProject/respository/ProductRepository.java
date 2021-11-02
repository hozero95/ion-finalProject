package com.example.finalProject.respository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.ProductVO;

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
	
	/* 
	 * 메인화면 - 제철 상품 불러오기, 제철상품화면 - 제철 상품 불러오기
	 * select *
	 *	 from product
	 *  where product_season = {{product_season}}
	 *  order by product_regdate desc, product_name;
	 */
	public List<ProductVO> findByProductSeason(Long productSeason, Sort sort);
	
	/* 
	 * 상품상세화면 - 상세정보불러오기
	 * select *
	 *	 from product
	 *	where product_unum = {{product_unum}};
	 */
	public List<ProductVO> findByProductUnum(Long productUnum);
}
