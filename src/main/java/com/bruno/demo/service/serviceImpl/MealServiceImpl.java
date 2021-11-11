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
		String json = mealServiceHelper.callApi();
		Meals meals = mealServiceHelper.jsonToMeal(json);
		return meals;
	}

	@Override
	public Meal findById(String idMeal) throws JsonMappingException, JsonProcessingException {
		String json = mealServiceHelper.callApi();
		Meals meals = mealServiceHelper.jsonToMeal(json);
		Meal meal = null;
		
		for(int i = 0 ; i < meals.getMeals().size(); i++) {
			if(meals.getMeals().get(i).getIdMeal().equals(idMeal)) {
				meal = meals.getMeals().get(i);
				break;
			}
		}
		return meal;
	}

	

}
