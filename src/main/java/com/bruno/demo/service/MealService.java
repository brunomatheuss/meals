package com.bruno.demo.service;

import com.bruno.demo.entity.Meal;
import com.bruno.demo.entity.Meals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface MealService {

	public Meals buscar() throws JsonMappingException, JsonProcessingException;
	
	public Meal buscarPorId(String idMeal) throws JsonMappingException, JsonProcessingException;
	
}
