package com.example.finalProject.domain.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarUseProDTO {
	private Long userUnum;
	private Long productUnum;
	private Long cartCount;
	private Long cartPrice;
	private String cartAddress;
	private String userId;
	private String userPassword;
	private String userEmail;
	private String userAddress;
	private String userTel;
	private Date userRegdate;
	private Long userRole;
	private Long categoryUnum;
	private String productName;
	private Long productPrice;
	private Date productRegdate;
	private Long productSeason;
	private String productImage01Path;
	private String productImage02Path;
}
