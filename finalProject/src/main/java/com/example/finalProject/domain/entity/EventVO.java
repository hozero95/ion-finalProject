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
@Entity(name = "event")
public class EventVO {
	@Id
	@Column(name = "event_unum")
	private Long eventUnum;
	@Column(name = "event_title")
	private String eventTitle;
	@Column(name = "event_content")
	private String eventContent;
	@Column(name = "event_regdate")
	private Date eventRegdate;
	@Column(name = "event_enddate")
	private Date eventEnddate;
	@Column(name = "event_image01_path")
	private String eventImage01Path;
	@Column(name = "event_image02_path")
	private String eventImage02Path;
}