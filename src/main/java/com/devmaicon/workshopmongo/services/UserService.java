package com.devmaicon.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmaicon.workshopmongo.domain.User;
import com.devmaicon.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
			return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDto(UserDTO objdto) {
		return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
	}
}
