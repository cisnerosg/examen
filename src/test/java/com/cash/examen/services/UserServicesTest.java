package com.cash.examen.services;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cash.examen.dto.UserDto;
import com.cash.examen.exceptions.UserException;
import com.cash.examen.models.User;
import com.cash.examen.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicesTest {
	
	@MockBean
	private UserRepository repository;
	
	@Autowired
	private UserService service;
	
	@Test
	public void whenCallFindByIdWithExistentIdThenReturnUserDto() throws UserException{
		Long userId = 1L;
		
		User user = getUser();
		Optional<User> optional = Optional.of(user); 
		Mockito.when(repository.findById(userId)).thenReturn(optional);
		UserDto res = service.findById(userId);
		assertEquals(user.getEmail(), res.getEmail());
		assertEquals(user.getFirstName(), res.getFirstName());
		assertEquals(user.getLastName(), res.getLastName());
	}
	
	
	@Test(expected = UserException.class)
	public void whenCallFindByIdWithInexistentIdThenReturnException() throws UserException{
		Long userId = 1L;
		Optional<User> optional = Optional.empty(); 
		Mockito.when(repository.findById(userId)).thenReturn(optional);
		service.findById(userId);
		
	}
	
	@Test	
	private User getUser(){
		User user = new User();
		user.setEmail("nombre@email.com");
		user.setFirstName("firstName");
		user.setLastName("LastName");
		
		return user;
		
	}

}
