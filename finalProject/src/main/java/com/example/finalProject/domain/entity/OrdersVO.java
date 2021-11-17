package com.example.finalProject.domain.entity;

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
@Entity(name = "orders")
public class OrdersVO {
	@Id
	@Column(name = "order_unum")
	private Long orderUnum;
	@Column(name = "order_status")
	private Long orderStatus;
	@Column(name = "order_address")
	private String orderAddress;
	@Column(name = "order_regdate")
	private Date orderRegdate;
	@Column(name = "order_message")
	private String orderMessage;
	@Column(name = "user_unum")
	private Long userUnum;
	@Column(name = "order_type")
	private Long orderType;
}
