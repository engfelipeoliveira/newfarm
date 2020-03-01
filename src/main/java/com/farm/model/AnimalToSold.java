package com.farm.model;

import java.io.Serializable;

public class AnimalToSold implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String type;
	private Double weightToSold;
	private Double valueSold;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getWeightToSold() {
		return weightToSold;
	}
	public void setWeightToSold(Double weightToSold) {
		this.weightToSold = weightToSold;
	}
	public Double getValueSold() {
		return valueSold;
	}
	public void setValueSold(Double valueSold) {
		this.valueSold = valueSold;
	}
	

}
