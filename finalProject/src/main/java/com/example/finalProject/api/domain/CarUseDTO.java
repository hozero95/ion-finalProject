package com.example.finalProject.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarUseDTO {
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
}
