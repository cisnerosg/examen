package com.cash.examen;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cash.examen.dto.UserDto;
import com.cash.examen.models.User;

@SpringBootApplication
public class ExamenApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper =  new ModelMapper();
		/*Excluyo el campo Loan*/
	    modelMapper.addMappings(new PropertyMap<UserDto, User>() {
	        protected void configure() {
	        	skip(destination.getLoans());
	        }
	      });
	    
	    return modelMapper;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}

}

