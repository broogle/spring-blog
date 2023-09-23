package com.spring.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blog.dto.PostDTO;
import com.spring.blog.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping
	public ResponseEntity<HttpStatus> createPost(@Valid @RequestBody PostDTO postDTO) throws IllegalAccessException {
		
		postService.createPost(postDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getPostById(@Valid @PathVariable @RequestBody Long id) {
	
		return new ResponseEntity(postService.getPostById(id),HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity getAllPosts() {
		
		return new ResponseEntity(postService.getAllPosts(),HttpStatus.OK);
	}
}
