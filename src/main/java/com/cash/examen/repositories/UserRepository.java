package com.cash.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cash.examen.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
