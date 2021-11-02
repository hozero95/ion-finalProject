package com.example.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.service.EventService;

@RequestMapping("/api/event")
@RestController
public class EventController {
	@Autowired
	private EventService eventService;

	@GetMapping(value = "/show/event", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventVO>> showEvent() {
		List<EventVO> event = eventService.showEvent();
		return new ResponseEntity<List<EventVO>>(event, HttpStatus.OK);
	}
}
