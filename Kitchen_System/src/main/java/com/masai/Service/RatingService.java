package com.masai.Service;

import com.masai.Exception.RatingException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Rating;

public interface RatingService {
	public Rating provideRatingToRecipe(String key, Rating rating) throws UserException, RecipeException, RatingException;
}
