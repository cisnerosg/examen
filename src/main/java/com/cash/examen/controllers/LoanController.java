package com.cash.examen.controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cash.examen.dto.LoanPageable;
import com.cash.examen.services.LoanService;

@RestController
@RequestMapping("loans")
public class LoanController {
	
	private final LoanService loanService;
	
	@Autowired
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}
	
	@GetMapping()
    public ResponseEntity<LoanPageable> getLoans(@RequestParam(value = "userId", required = false)  Long userId, Pageable pageable) {
		LoanPageable page = loanService.findByUserId(userId, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
	}
	
}
