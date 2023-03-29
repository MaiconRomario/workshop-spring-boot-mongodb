package com.devmaicon.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.workshopmongo.domain.Post;
import com.devmaicon.workshopmongo.repository.PostRepository;
import com.devmaicon.workshopmongo.services.exception.ObjectNotFoudExeception;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
			return user.orElseThrow(() -> new ObjectNotFoudExeception("object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
	
	