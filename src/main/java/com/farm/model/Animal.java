package com.farm.model;

import java.io.Serializable;

public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;

	private Double weight;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	

}
