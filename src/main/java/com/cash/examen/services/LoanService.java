package com.cash.examen.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cash.examen.builders.LoanPageableBuilder;
import com.cash.examen.dto.LoanPageable;
import com.cash.examen.models.Loan;
import com.cash.examen.repositories.LoanRepository;

@Service
public class LoanService {
	
	private final LoanRepository loanRepository;
	
	@Autowired
	public LoanService(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}
	
	/*busco dependiendo si tiene o no el filtro, si fuesen mas habria que usar criteria o algun concepto similar*/
	public LoanPageable findByUserId(Long userId, Pageable pageable) {
		Page<Loan> page;		
		if(userId != null) {
			page =  loanRepository.findByUserId(userId, pageable);
		}else {
	        page = loanRepository.findAll(pageable);
		} 
		LoanPageableBuilder builder = new LoanPageableBuilder();
		return builder.setItems(page.getContent()).setPaging(page.getPageable(), page.getTotalElements()).createLoandPageable();
    }
	
	
}
