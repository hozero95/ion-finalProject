package com.example.finalProject.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "cart")
@IdClass(CartVO.CartPK.class)
public class CartVO {
	@Id
	private long userUnum;
	@Id
	private long productUnum;
	@Column(name = "cart_count")
	private long cartCount;
	@Column(name = "cart_price")
	private long cartPrice;
	@Column(name = "cart_address")
	private String cartAddress;

	@SuppressWarnings("serial")
	@EqualsAndHashCode
	@Embeddable
	static class CartPK implements Serializable {
		@Column(name = "user_unum")
		private long userUnum;
		@Column(name = "product_unum")
		private long productUnum;
	}
}