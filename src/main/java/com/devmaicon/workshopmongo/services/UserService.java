package com.devmaicon.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.workshopmongo.domain.User;
import com.devmaicon.workshopmongo.repository.UserRepository;
import com.devmaicon.workshopmongo.services.exception.ObjectNotFoudExeception;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
			return user.orElseThrow(() -> new ObjectNotFoudExeception("object not found"));
	}
}
