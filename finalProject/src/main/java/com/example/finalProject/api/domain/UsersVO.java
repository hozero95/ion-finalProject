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
@Entity(name = "users")
public class UsersVO {
	@Id
	@Column(name = "user_unum")
	private Long userUnum;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "user_password")
	private String userPassword;
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_address")
	private String userAddress;
	@Column(name = "user_tel")
	private String userTel;
	@Column(name = "user_regdate")
	private Date userRegdate;
	@Column(name = "user_role")
	private Long userRole;
}
