package com.example.finalProject.api.domain;

import java.util.Date;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestDTO {
	private Long count;
	private Long productUnum;
	private String categoryCode;
	private String productName;
	private Long productPrice;
	private Date productRegdate;
	private Long productSeason;
	private String productImage01Path;
	private String productImage02Path;
}
