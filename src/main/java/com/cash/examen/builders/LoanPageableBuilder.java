package com.cash.examen.builders;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import com.cash.examen.dto.LoanDto;
import com.cash.examen.dto.LoanPageable;
import com.cash.examen.dto.Paging;
import com.cash.examen.models.Loan;

public class LoanPageableBuilder {

	private final ModelMapper modelMapper;
	
	private List<LoanDto> items;
    private Paging paging;
    
    
	public LoanPageableBuilder() {
		this.modelMapper = new ModelMapper();
	} 
	
	public LoanPageableBuilder setItems(List<Loan> items) {
		Type listType = new TypeToken<List<LoanDto>>() {}.getType();
		this.items = modelMapper.map(items, listType);
		return this;
    }
	
	public LoanPageableBuilder setPaging(Pageable pageable, Long total) {
		paging = new Paging(pageable.getPageNumber(), pageable.getPageSize(), total);
		return this;
	}
	
	public LoanPageable createLoandPageable() {
	      return new LoanPageable(items, paging);
	   }
    
    
	

}
