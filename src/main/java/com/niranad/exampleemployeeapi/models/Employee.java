package com.niranad.exampleemployeeapi.models;

import java.time.LocalDate;

import com.niranad.exampleemployeeapi.utils.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String email;
	private byte age;
	private String nationality;
	private Gender gender;
}
