package com.example.finalProject.domain.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PayOrdRepProDTO {
	private Long paymentUnum;
	private Long orderUnum;
	private Long productUnum;
	private Long paymentCount;
	private Long paymentPrice;
	private Date paymentRegdate;
	private Long orderStatus;
	private String orderAddress;
	private Date orderRegdate;
	private String orderMessage;
	private Long userUnum;
	private Long orderType;
	private Long replyUnum;
	private String replyContent;
	private Date replyRegdate;
	private String replyImage01Path;
	private Long categoryUnum;
	private String productName;
	private Long productPrice;
	private Date productRegdate;
	private Long productSeason;
	private String productImage01Path;
	private String productImage02Path;
}
