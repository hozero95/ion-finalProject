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
@Entity(name = "delivery")
public class DeliveryVO {
	@Id
	@Column(name = "delivery_unum")
	private Long deliveryUnum;
	@Column(name = "order_unum")
	private Long orderUnum;
	@Column(name = "delivery_status")
	private Long deliveryStatus;
	@Column(name = "delivery_address")
	private String deliveryAddress;
	@Column(name = "delivery_regdate")
	private Date deliveryRegdate;
	@Column(name = "delivery_enddate")
	private Date deliveryEnddate;
}