package com.spring.blog.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO {

	private String title;
	
	private String content;
	
	private Instant updatedOn;
	
	private Instant createdOn;
	
	private String username;
	
}
