package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity 
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recipeId;
	@NotNull(message = "title field should not be null")
	@NotBlank(message = "title field should not be blank")
	private String title;
	private String description;
	@NotNull(message = "ingredients field should not be null")
	@NotBlank(message = "title field should not be blank")
	private String ingredients;
	private String instrucations;
	private String preparationTime;
	private String difficultyLevel;
	
	
	
}