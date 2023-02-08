package com.niranad.exampleemployeeapi.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	@NotNull
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotNull
	private String password;
	private boolean enabled = true;
	private boolean credentialsExpired = false;
	private boolean expired = false;
	private boolean locked = false;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "AccountRole", 
			joinColumns = @JoinColumn(name = "accountId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id")
	)
	private Set<Role> roles;
}
