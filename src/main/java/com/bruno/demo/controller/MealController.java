package com.bruno.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.demo.entity.Meal;
import com.bruno.demo.entity.Meals;
import com.bruno.demo.service.MealService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("meal")
public class MealController {
	
	@Autowired
	private MealService mealService;
	
	@GetMapping("findAll")
	Meals findAll() throws JsonMappingException, JsonProcessingException {
		return mealService.findAll();
	}
	
	@GetMapping("findById")
	Meal findById(@RequestParam String idMeal) throws JsonMappingException, JsonProcessingException {
		return mealService.findById(idMeal);
	}
	
}
