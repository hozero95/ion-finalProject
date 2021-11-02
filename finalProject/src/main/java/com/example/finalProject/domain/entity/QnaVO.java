package com.example.finalProject.domain.entity;

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
@Entity(name = "qna")
public class QnaVO {
	@Id
	@Column(name = "qna_unum")
	private Long qnaUnum;
	@Column(name = "user_unum")
	private Long userUnum;
	@Column(name = "qna_title")
	private String qnaTitle;
	@Column(name = "qna_content")
	private String qnaContent;
	@Column(name = "qna_comment")
	private Long qnaComment;
	@Column(name = "qna_regdate")
	private Date qnaRegdate;
}
