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
public class PayRepDTO {
	private Long paymentUnum;
	private Long orderUnum;
	private Long productUnum;
	private Long paymentCount;
	private Long paymentPrice;
	private Date paymentRegdate;
	private Long replyUnum;
	private String replyContent;
	private Date replyRegdate;
	private String replyImage01Path;
}
