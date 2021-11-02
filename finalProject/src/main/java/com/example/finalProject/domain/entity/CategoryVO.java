package com.example.finalProject.domain.entity;

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
@Entity(name = "category")
public class CategoryVO {
	@Id
	@Column(name = "category_code")
	private String categoryCode;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_ref")
	private String categoryRef;
	@Column(name = "category_used")
	private Long categoryUsed;
}