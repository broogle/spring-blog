package com.spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.blog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	
}
