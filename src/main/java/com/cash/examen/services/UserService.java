package com.cash.examen.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.examen.models.User;
import com.cash.examen.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findById(Long id) {
        Optional<User> res = userRepository.findById(id);
        if(res.isPresent()) {
        	return res.get();
        }else {
        	return new User();
        }
    }
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
