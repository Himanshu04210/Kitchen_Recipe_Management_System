package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ratingId;
	private Integer userId;
	private Integer recipeId;
	private double rating;
	private String description;
}
