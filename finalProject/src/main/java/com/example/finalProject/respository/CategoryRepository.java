package com.example.finalProject.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalProject.domain.entity.CategoryVO;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryVO, Long> {
	public List<CategoryVO> findAll();
	
	/*    메인화면 - nav 불러오기
	 	* select *
	 	*	 from category
	 	*	where category_used is null
	 	*	   or category_used = 0; 
	 	*/
	public List<CategoryVO> findByCategoryUsedIsNullOrCategoryUsed(Long categoryUsed);
	
	/*     메인화면 - BEST nav 불러오기, 베스트상품화면 - 메뉴 불러오기
		 * select *
		 *	 from category
		 *	where category_ref is null
		 *	  and (category_used is null
		 *	   or category_used = 0);
		 */
	public List<CategoryVO> findByCategoryRefIsNullAndCategoryUsedIsNullOrCategoryUsedOrderByCategoryUnum(Long categoryUsed);
	
}