package com.niranad.exampleemployeeapi.models;

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
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String code;
	private String name;
}
