package com.spring.blog.models;

import java.time.Instant;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column
	private String title;
	
	@NotBlank
	@Column
	private String content;
	
	@NotBlank
	@Column
	private Instant createdOn;
	
	@NotBlank
	@Column
	private Instant updatedOn;

	@NotBlank
	@Column
	private String username;
}
