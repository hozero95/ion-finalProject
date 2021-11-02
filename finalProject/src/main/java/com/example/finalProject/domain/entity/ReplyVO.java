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
@Entity(name = "reply")
public class ReplyVO {
	@Id
	@Column(name = "reply_unum")
	private Long replyUnum;
	@Column(name = "payment_unum")
	private Long paymentUnum;
	@Column(name = "reply_content")
	private String replyContent;
	@Column(name = "reply_regdate")
	private Date replyRegdate;
	@Column(name = "reply_image01_path")
	private String replyImage01Path;
}
