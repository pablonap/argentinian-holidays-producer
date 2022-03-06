package com.practiceproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practiceproject.dto.HolidayDTO;
import com.practiceproject.producer.HolidayEventProducer;
import com.practiceproject.repository.HolidayRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code HolidayService} class represents a service layer for the
 * end user to access the database where argentinian holidays are stored.
 *
 * @author pablo.napoli
 *
 */
@Service
@AllArgsConstructor
@Slf4j
public class HolidayService implements IHolidayService {
    private final HolidayRepository repository;
    private final ModelMapper mapper;
    private final HolidayEventProducer holidayEventProducer;

    public void publishHolidays() throws JsonProcessingException {
        List<HolidayDTO> holidays = repository.findAll()
                .stream()
                .map(a -> mapper.map(a, HolidayDTO.class))
                .collect(Collectors.toList());

        log.info("Argentinian holidays: " + holidays);

        for (HolidayDTO dto : holidays) {
            holidayEventProducer.sendHolidayEvent(dto);
        }
    }
}
