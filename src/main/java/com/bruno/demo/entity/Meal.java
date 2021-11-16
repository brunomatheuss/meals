package com.bruno.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

	String idMeal;
	String strMeal;
	String strCategory;
	String strArea;
	String strInstructions;
	String strMealThumb;

}
