package com.practiceproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practiceproject.dto.HolidayDTO;
import java.util.List;

/**
 * The {@code IHolidayService} interface represents a service layer for the
 * end user to access the database where argentinian holidays are stored.
 *
 * @author pablo.napoli
 *
 */
public interface IHolidayService {
    /**
     * Publish all argentinian holidays.
     */
    void publishHolidays() throws JsonProcessingException;
}
