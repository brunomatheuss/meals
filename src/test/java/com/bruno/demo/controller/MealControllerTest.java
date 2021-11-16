package com.bruno.demo.controller;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.bruno.demo.entity.Meal;
import com.bruno.demo.service.MealService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.http.ContentType;

@WebMvcTest
public class MealControllerTest {

	@Autowired
	private MealController mealController;
	
	@MockBean
	private MealService mealService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.mealController);
	}
	
	@Test
	public void mustReturnSuccess_WhenFindByName() throws JsonMappingException, JsonProcessingException, Exception {

		when(this.mealService.findByName("Corba"))
			.thenReturn(new Meal("52977", "Corba", "Side", "Turkish", "Pick through your lentils for any foreign debris, rinse them 2 "
					+ "or 3 times, drain, and set aside.  Fair warning, this will probably turn your lentils into a solid block that "
					+ "you’ll have to break up later In a large pot over medium-high heat, sauté the olive oil and the onion with a "
					+ "pinch of salt for about 3 minutes, then add the carrots and cook for another 3 minutes. Add the tomato paste and"
					+ " stir it around for around 1 minute. Now add the cumin, paprika, mint, thyme, black pepper, and red pepper as "
					+ "quickly as you can and stir for 10 seconds to bloom the spices. Congratulate yourself on how amazing your house "
					+ "now smells. Immediately add the lentils, water, broth, and salt. Bring the soup to a (gentle) boil. After it has "
					+ "come to a boil, reduce heat to medium-low, cover the pot halfway, and cook for 15-20 minutes or until the "
					+ "lentils have fallen apart and the carrots are completely cooked. After the soup has cooked and the lentils are "
					+ "tender, blend the soup either in a blender or simply use a hand blender to reach the consistency you desire. "
					+ "Taste for seasoning and add more salt if necessary. Serve with crushed-up crackers, torn up bread, or something "
					+ "else to add some extra thickness.  You could also use a traditional thickener (like cornstarch or flour), but I "
					+ "prefer to add crackers for some texture and saltiness.  Makes great leftovers, stays good in the fridge for "
					+ "about a week.", "https://www.themealdb.com/images/media/meals/58oia61564916529.jpg"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("v1/meals/{strMeal}", "Corba")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
}
