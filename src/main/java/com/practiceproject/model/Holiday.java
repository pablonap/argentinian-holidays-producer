package com.practiceproject.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code Holiday} class represents the data model
 * for an argentinian holiday.
 *
 * @author pablo.napoli
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="holiday")
public class Holiday {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private String name;

	@Column(name="holiday_date")
	private String holidayDate;
}
