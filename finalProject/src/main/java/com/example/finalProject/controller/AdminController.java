package com.example.finalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalProject.domain.entity.CategoryVO;
import com.example.finalProject.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(value = "/category/add", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> categoryAdd(@RequestBody CategoryVO categoryVO){
		return adminService.categoryAdd(categoryVO) > 0 ? new ResponseEntity<String>("success", HttpStatus.OK) : new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	
}
