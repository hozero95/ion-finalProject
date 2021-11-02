package com.example.finalProject.domain.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersVO {
	@JsonIgnore
	@Id
	@Column(name = "user_unum")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_unum")
	@SequenceGenerator(name = "seq_user_unum", sequenceName = "seq_user_unum", allocationSize = 1)
	private Long userUnum;

	@Column(name = "user_id")
	private String userId;

	@JsonIgnore
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

	@ManyToMany
	@JoinTable(name = "user_authority",
		joinColumns = { @JoinColumn(name = "user_unum", referencedColumnName = "user_unum") },
		inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "authority_name") })
	private Set<Authority> authorities;
}
