package com.acn.learnspringdatarest.learndatarest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
	name = "_user_",
	uniqueConstraints = { 
		@UniqueConstraint(columnNames = {"first_name", "last_name"})
	}
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(
		name = "first_name",
		nullable = false,
		length = 255
	)
	private String firstname;
	@Column(
		name = "last_name",
		nullable = false,
		length = 255
	)
	private String lastname;
	@Column(
		nullable = false,
		length = 255,
		unique = true
	)
	private String email;
}