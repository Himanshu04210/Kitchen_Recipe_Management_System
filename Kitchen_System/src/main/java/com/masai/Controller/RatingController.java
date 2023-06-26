package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.RatingException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Rating;
import com.masai.Service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/rating/{key}")
	public ResponseEntity<Rating> provideRating(@PathVariable String key, @RequestBody Rating rating) throws UserException, RecipeException, RatingException {
		Rating rated = ratingService.provideRatingToRecipe(key, rating);
		
		return new ResponseEntity<Rating>(rated, HttpStatus.OK);
	}
}
