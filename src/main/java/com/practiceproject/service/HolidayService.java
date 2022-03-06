package com.practiceproject.service;

import com.practiceproject.dto.HolidayDTO;
import com.practiceproject.repository.HolidayRepository;
import lombok.AllArgsConstructor;
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
public class HolidayService implements IHolidayService {
    private final HolidayRepository repository;
    private ModelMapper mapper;

    public List<HolidayDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(a -> mapper.map(a, HolidayDTO.class))
                .collect(Collectors.toList());
    }
}
