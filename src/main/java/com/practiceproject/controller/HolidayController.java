package com.practiceproject.controller;

import java.util.List;

import com.practiceproject.dto.HolidayDTO;
import com.practiceproject.service.HolidayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/holidays")
@AllArgsConstructor
public class HolidayController {
	private final HolidayService service;
	
	@GetMapping
	public void publishHolidays() {
		service.publishHolidays();
	}
}
