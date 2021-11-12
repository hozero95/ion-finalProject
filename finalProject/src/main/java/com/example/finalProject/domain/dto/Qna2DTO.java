package com.example.finalProject.domain.dto;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Qna2DTO {
	private Long qnaUnum;
	private Long userUnum;
	private String qnaTitle;
	private String qnaContent;
	private Long qnaComment;
	private Date qnaRegdate;
	private String resTitle;
	private String resContent;
	private Long resComment;
}
