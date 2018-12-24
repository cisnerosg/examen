package com.cash.examen.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cash.examen.dto.UserDto;
import com.cash.examen.exceptions.UserException;
import com.cash.examen.models.User;
import com.cash.examen.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserService(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}
	
	public UserDto findById(Long id) throws UserException {
        Optional<User> res = userRepository.findById(id);
        if(res.isPresent()) {
        	return modelMapper.map(res.get(), UserDto.class);
        }else {
        	throw new UserException("Usuario no encontrado con id: " + id);
        }
    }
	
	public UserDto create(UserDto userDto) throws UserException {
		try {
			User user = modelMapper.map(userDto, User.class);
			user = userRepository.save(user);
			return modelMapper.map(user, UserDto.class);	
		} catch (Exception e) {
        	throw new UserException("Ocurrió un error al tratar de crear el usuario " + userDto.getFirstName());
		}
		
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
