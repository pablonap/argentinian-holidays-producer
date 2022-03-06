package com.practiceproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practiceproject.service.HolidayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code HolidayController} class handles all the request for
 * methods on the "/api/v1/holidays" url.
 *
 * @author pablo.napoli
 *
 */
@RestController
@RequestMapping("/api/v1/holidays")
@AllArgsConstructor
public class HolidayController {
	private final HolidayService service;
	
	@GetMapping
	public void publishHolidays() throws JsonProcessingException {
		service.publishHolidays();
	}
}
