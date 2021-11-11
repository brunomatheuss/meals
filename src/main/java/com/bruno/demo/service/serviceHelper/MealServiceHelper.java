package com.bruno.demo.service.serviceHelper;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bruno.demo.entity.Meals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MealServiceHelper {

	public String callApi() throws JsonMappingException, JsonProcessingException {

		WebClient webClient = WebClient.create();
		
		String responseJson = webClient.get().uri("https://www.themealdb.com/api/json/v1/1/search.php?s=").retrieve()
				.bodyToMono(String.class).block();

		
		return responseJson;
	}
	
	public Meals jsonToMeal(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		Meals meal = objectMapper.readValue(json, Meals.class);
		
		return meal;
	}
	
}
