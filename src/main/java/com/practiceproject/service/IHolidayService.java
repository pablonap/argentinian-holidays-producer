package com.practiceproject.service;

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
     * Return all argentinian holidays
     *
     * @return {@code List<HolidayDTO>}
     */
    List<HolidayDTO> findAll();
}
