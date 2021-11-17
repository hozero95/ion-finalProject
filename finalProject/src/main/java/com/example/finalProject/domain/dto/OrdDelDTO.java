package com.example.finalProject.domain.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrdDelDTO {
	private Long orderUnum;
	private Long orderStatus;
	private String orderAddress;
	private Date orderRegdate;
	private String orderMessage;
	private Long orderType;
	private Long userUnum;
	private Long deliveryUnum;
	private Long deliveryStatus;
	private String deliveryAddress;
	private Date deliveryRegdate;
	private Date deliveryEnddate;
}
