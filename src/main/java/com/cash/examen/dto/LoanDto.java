package com.cash.examen.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanDto {
	@JsonProperty("id")
    private Long id; 
    
    @JsonProperty("total")
	private BigDecimal total;
	
	@JsonProperty("user_id")
    private Long userId;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}    
    
    
}
