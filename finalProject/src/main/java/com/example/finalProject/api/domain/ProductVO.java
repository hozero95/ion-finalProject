package com.example.finalProject.api.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "product")
public class ProductVO {
	@Id
	@Column(name = "product_unum")
	private long productUnum;
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private long productPrice;
	@Column(name = "product_regdate")
	private Date productRegdate;
	@Column(name = "product_season")
	private Long productSeason;
	@Column(name = "product_image01_path")
	private String productImage01Path;
	@Column(name = "product_image02_path")
	private String productImage02Path;
}
