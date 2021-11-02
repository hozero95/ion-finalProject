package com.example.finalProject.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	@NotNull
	@Size(min = 3, max = 50)
	private String userId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	@Size(min = 3, max = 100)
	private String userPassword;

	@NotNull
	@Size(min = 3, max = 50)
	private String userEmail;

	@NotNull
	@Size(min = 3, max = 200)
	private String userAddress;

	@NotNull
	@Size(min = 3, max = 50)
	private String userTel;
}
