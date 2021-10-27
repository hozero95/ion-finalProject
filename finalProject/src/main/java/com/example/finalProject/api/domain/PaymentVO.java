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
@Entity(name = "payment")
public class PaymentVO {
	@Id
	@Column(name = "payment_unum")
	private Long paymentUnum;
	@Column(name = "order_unum")
	private Long orderUnum;
	@Column(name = "product_unum")
	private Long productUnum;
	@Column(name = "payment_count")
	private Long paymentCount;
	@Column(name = "payment_price")
	private Long paymentPrice;
	@Column(name = "payment_regdate")
	private Date paymentRegdate;
}
