package com.farm.model;

import java.io.Serializable;

public class QuantitySold implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Integer quantity;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

}
