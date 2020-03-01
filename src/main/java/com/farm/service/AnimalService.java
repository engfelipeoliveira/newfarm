package com.farm.service;

import java.util.List;

import com.farm.model.QuantitySold;
import com.farm.model.WeightAverage;

public interface AnimalService {
	
	void add(Double weight, String animalType);
	
	List<WeightAverage> calculateWeightAverage();
	
	List<QuantitySold> getQuantitySold();
	
	Double getStockValue();
	
	Double getFarmValueByArgs(Double cow, Double pig, Double chicken);

}
