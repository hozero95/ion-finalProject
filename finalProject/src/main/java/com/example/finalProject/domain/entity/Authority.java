package com.example.finalProject.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authority")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
	@Id
	@Column(name = "authority_name")
	private String authorityName;
}
