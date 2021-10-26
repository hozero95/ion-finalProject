package com.example.finalProject.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalProject.api.domain.EventVO;
import com.example.finalProject.api.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;

	public List<EventVO> findAll() {
		List<EventVO> event = new ArrayList<>();
		eventRepository.findAll().forEach(e -> event.add(e));
		return event;
	}
}
