package com.cash.examen.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import com.cash.examen.models.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	//Page<Loan> findByUser_id(Long user_id, Pageable pageable);
	
	@Nullable
	Page<Loan> findByUserId(@Nullable Long user_id, Pageable pageable);
	
	//@Query("select l from Loan where l.user_id = :user_id") 
   // Page<Loan> findByUser_id(@Param("user_id") Long user_id, Pageable pageable); 


}
