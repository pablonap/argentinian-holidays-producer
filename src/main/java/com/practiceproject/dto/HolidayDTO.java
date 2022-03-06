package com.practiceproject.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code HolidayDTO} class represents the data of an
 * argentinian holiday to be sent whenever the end point is called.
 *
 * @author pin1
 *
 */
@Data
@NoArgsConstructor
public class HolidayDTO {
	private Long id;
    private String name;
	private String holidayDate;
}
