package com.farm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.model.QuantitySold;
import com.farm.model.WeightAverage;
import com.farm.service.AnimalService;

@RestController
@RequestMapping("/animal")
public class AnimalController {

	private final AnimalService animalService;
	
	public AnimalController(AnimalService animalService) {
		this.animalService = animalService;
	}

	@PostMapping(value = "/add/weight/{weight}/type/{type}")
	public void adicionar(@PathVariable("weight") Double weight, @PathVariable("type") String type) {
		animalService.add(weight, type);
	}
	
	@GetMapping(value = "/calculateWeightAverage")
	public List<WeightAverage> calculateWeightAverage() {
		return animalService.calculateWeightAverage();
		
	}
	
	@GetMapping(value = "/getQuantitySold")
	public List<QuantitySold> getQuantitySold() {
		return animalService.getQuantitySold();
		
	}
	
	
	@GetMapping(value = "/getStockValue")
	public Double getStockValue() {
		return animalService.getStockValue();
		
	}
	
	@GetMapping(value = "/getFarmValueByArgs/cow/{cow}/pig/{pig}/chicken/{chicken}")
	public Double getFarmValueByArgs(@PathVariable("cow") Double cow, @PathVariable("pig") Double pig, @PathVariable("chicken") Double chicken) {
		return animalService.getFarmValueByArgs(cow, pig, chicken);
		
	}

}