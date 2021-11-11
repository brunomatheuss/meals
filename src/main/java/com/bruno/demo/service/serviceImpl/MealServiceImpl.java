package com.bruno.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.demo.entity.Meal;
import com.bruno.demo.entity.Meals;
import com.bruno.demo.service.MealService;
import com.bruno.demo.service.serviceHelper.MealServiceHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class MealServiceImpl implements MealService {
	
	@Autowired
	private MealServiceHelper mealServiceHelper;

	public Meals findAll() throws JsonMappingException, JsonProcessingException {
		String json = mealServiceHelper.callApi(null);
		Meals meals = mealServiceHelper.jsonToMeal(json);
		return meals;
	}

	@Override
	public Meal findByName(String strMeal) throws JsonMappingException, JsonProcessingException {
		String json = mealServiceHelper.callApi(strMeal);
		Meals meals = mealServiceHelper.jsonToMeal(json);
		Meal meal = meals.getMeals().get(0);
		return meal;
	}

	

}
