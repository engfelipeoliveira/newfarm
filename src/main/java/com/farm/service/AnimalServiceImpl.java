package com.farm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.farm.model.Animal;
import com.farm.model.AnimalToSold;
import com.farm.model.QuantitySold;
import com.farm.model.WeightAverage;

@Service
public class AnimalServiceImpl implements AnimalService {

	List<Animal> allAnimals = new ArrayList<Animal>();
	List<AnimalToSold> animalsToSold = new ArrayList<AnimalToSold>();

	public AnimalServiceImpl(List<Animal> animals) {
		
		AnimalToSold animalToSold = new AnimalToSold();
		animalToSold.setType("cow");
		animalToSold.setValueSold(500D);
		animalToSold.setWeightToSold(300D);
		animalsToSold.add(animalToSold);

		animalToSold = new AnimalToSold();
		animalToSold.setType("pig");
		animalToSold.setValueSold(250D);
		animalToSold.setWeightToSold(100D);
		animalsToSold.add(animalToSold);

		animalToSold = new AnimalToSold();
		animalToSold.setType("chicken");
		animalToSold.setValueSold(5D);
		animalToSold.setWeightToSold(0.5D);
		animalsToSold.add(animalToSold);
	}

	@Override
	public void add(Double weight, String animalType) {
		Animal animal = new Animal();
		animal.setWeight(weight);
		animal.setType(animalType);
		this.allAnimals.add(animal);
	}

	@Override
	public List<WeightAverage> calculateWeightAverage() {

		Double averageCow = calculateWeightAverageByAnimalType("cow");
		Double averagePig = calculateWeightAverageByAnimalType("pig");
		Double averageChicken = calculateWeightAverageByAnimalType("chicken");

		List<WeightAverage> listWeightAverage = new ArrayList<WeightAverage>();
		
		WeightAverage weightAverage = new WeightAverage();
		weightAverage.setType("cow");
		weightAverage.setWeight(averageCow);
		listWeightAverage.add(weightAverage);

		weightAverage = new WeightAverage();
		weightAverage.setType("pig");
		weightAverage.setWeight(averagePig);
		listWeightAverage.add(weightAverage);

		weightAverage = new WeightAverage();
		weightAverage.setType("chicken");
		weightAverage.setWeight(averageChicken);
		listWeightAverage.add(weightAverage);

		return listWeightAverage;
	}

	@Override
	public List<QuantitySold> getQuantitySold() {
		Integer quantityCow = getQuantityToSoldByAnimalType("cow");
		Integer quantityPig = getQuantityToSoldByAnimalType("pig");
		Integer quantityChicken = getQuantityToSoldByAnimalType("chicken");

		List<QuantitySold> listQuantitySold = new ArrayList<QuantitySold>();
		
		QuantitySold quantitySold = new QuantitySold();
		quantitySold.setType("cow");
		quantitySold.setQuantity(quantityCow);
		listQuantitySold.add(quantitySold);

		quantitySold = new QuantitySold();
		quantitySold.setType("pig");
		quantitySold.setQuantity(quantityPig);
		listQuantitySold.add(quantitySold);

		quantitySold = new QuantitySold();
		quantitySold.setType("chicken");
		quantitySold.setQuantity(quantityChicken);
		listQuantitySold.add(quantitySold);

		return listQuantitySold;
	}

	@Override
	public Double getFarmValueByArgs(Double cow, Double pig, Double chicken) {
		Integer quantityCow = getQuantityByAnimalType("cow");
		Integer quantityPig = getQuantityByAnimalType("pig");
		Integer quantityChicken = getQuantityByAnimalType("chicken");

		return (quantityCow * cow) + (quantityPig * pig) + (quantityChicken * chicken);

	}

	@Override
	public Double getStockValue() {
		List<Animal> animalsByType = this.allAnimals.stream().collect(Collectors.toList());

		Double stockValue = 0D;
		if (!animalsByType.isEmpty()) {
			for (Animal animal : animalsByType) {
				stockValue += animalsToSold.stream().filter(adc -> adc.getType().equalsIgnoreCase(animal.getType()))
						.findFirst().get().getValueSold();
			}

			return stockValue;
		}

		return 0D;
	}

	private Double calculateWeightAverageByAnimalType(String typeAnimal) {
		List<Animal> listAnimalByType = this.allAnimals.stream()
				.filter(animal -> animal.getType().equalsIgnoreCase(typeAnimal)).collect(Collectors.toList());
		Double weight = 0D;

		if (!listAnimalByType.isEmpty()) {
			int quantity = listAnimalByType.size();
			for (Animal animal : listAnimalByType) {
				weight += animal.getWeight();
			}

			return weight / quantity;
		}

		return 0D;
	}

	private Integer getQuantityToSoldByAnimalType(String typeAnimal) {
		return this.allAnimals.stream()
				.filter(animal -> animal.getType().equalsIgnoreCase(typeAnimal) && animal.getWeight() >= animalsToSold
						.stream().filter(ats -> ats.getType().equalsIgnoreCase(animal.getType())).findFirst().get()
						.getWeightToSold())
				.collect(Collectors.toList()).size();
	}
	
	private Integer getQuantityByAnimalType(String typeAnimal) {
		return this.allAnimals.stream()
				.filter(animal -> animal.getType().equalsIgnoreCase(typeAnimal))
				.collect(Collectors.toList()).size();
	}

}
