package com.example.finalProject.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.finalProject.domain.entity.EventVO;
import com.example.finalProject.respository.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;

	public List<EventVO> findAll() {
		List<EventVO> event = new ArrayList<>();
		eventRepository.findAll().forEach(e -> event.add(e));
		return event;
	}

	public List<EventVO> showEvent() {
		Date date = new Date();
		List<EventVO> event = new ArrayList<>();
		Sort sort = Sort.by("eventRegdate").descending().and(Sort.by("eventEnddate")).and(Sort.by("eventTitle"));
		eventRepository.findByEventEnddateIsNullOrEventEnddateGreaterThan(date, sort).forEach(e -> event.add(e));
		return event;
	}

	public List<EventVO> seasonShowEventImage(Long eventUnum) {
		List<EventVO> event = new ArrayList<>();
		eventRepository.findByEventUnum(eventUnum).forEach(e -> event.add(e));
		return event;
	}
}
