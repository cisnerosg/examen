package com.cash.examen.dto;

import java.util.List;

public class LoanPageable {
 
	private List<LoanDto> items;
    private Paging paging;
    
       
	public LoanPageable(List<LoanDto> items, Paging paging) {
		this.items = items;
		this.paging = paging;
	}

	public List<LoanDto> getItems() {
		return items;
	}
	
	public Paging getPaging() {
		return paging;
	}
    
}
