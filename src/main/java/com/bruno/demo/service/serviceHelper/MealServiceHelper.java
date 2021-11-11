package com.bruno.demo.service.serviceHelper;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bruno.demo.entity.Meals;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MealServiceHelper {

	private WebClient webClient = WebClient.create("https://www.themealdb.com");

	public String callApi(String strMeal) throws JsonMappingException, JsonProcessingException {
		
		String responseJson = webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/api/json/v1/1/search.php").queryParam("s", strMeal).build())
				.retrieve().bodyToMono(String.class).block();

		return responseJson;
	}

	public Meals jsonToMeal(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Meals meal = objectMapper.readValue(json, Meals.class);

		return meal;
	}

}
