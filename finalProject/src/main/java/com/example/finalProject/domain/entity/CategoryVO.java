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
	@Column(name = "category_unum")
	private Long categoryUnum;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "category_ref")
	private Long categoryRef;
	@Column(name = "category_used")
	private Long categoryUsed;
}