package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookMarkId;
	private Integer userId;
	private Integer recipeId;
}
