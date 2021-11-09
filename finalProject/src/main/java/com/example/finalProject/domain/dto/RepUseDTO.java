package com.example.finalProject.domain.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepUseDTO {
	private Long replyUnum;
	private Long paymentUnum;
	private String replyContent;
	private Date replyRegdate;
	private String replyImage01Path;
	private String userId;
}
