package com.spring.blog.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.controllers.AuthController;
import com.spring.blog.dto.PostDTO;
import com.spring.blog.models.Post;
import com.spring.blog.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	AuthController authController;
	
	public void createPost(@Valid PostDTO postDTO) throws IllegalAccessException {

		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		post.setCreatedOn(Instant.now());
		post.setUpdatedOn(Instant.now());
		
		String username = authController.getCurrentUser().orElseThrow(()-> new IllegalAccessException("No User Logged In "));
		
		post.setUsername(username);
		postRepository.save(post);
	}

	public Optional<Post> getPostById(@Valid Long id) {
		
		Optional<Post> post = postRepository.findById(id);
		return post;
	}

	public List<Post> getAllPosts() {

		List<Post> post = postRepository.findAll();
		
		return post;
	}
}
