package com.masai.ServiceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CurrentUserSession;
import com.masai.Exception.RatingException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Rating;
import com.masai.Model.Recipe;
import com.masai.Repository.RatingDao;
import com.masai.Repository.RecipeDao;
import com.masai.Repository.SessionRepo;
import com.masai.Service.RatingService;


@Service
public class RatingServiceImple implements RatingService{

	@Autowired
	private RatingDao ratingDao;
	
	@Autowired
	private SessionRepo sRepo;
	
	@Autowired
	private RecipeDao recipeDao;
	
	
	@Override
	public Rating provideRatingToRecipe(String key, Rating rating)
			throws UserException, RecipeException, RatingException {
		
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		

		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Integer userId = validCustomerSession.getUserId();
	
		Optional<Recipe> recipe = recipeDao.findById(rating.getRecipeId());
		if(recipe.isEmpty()) throw new RecipeException("Recipe is not present with this recipe id");
		
		
		List<Rating> alreadyRatedRecipies = ratingDao.findByUserId(userId);
		
		for(Rating rate: alreadyRatedRecipies) {
			
			if(rate.getRecipeId() == rating.getRecipeId()) throw new RatingException("Already rated to this recipe");
		}
		
		rating.setUserId(userId);
		
		Rating rated = ratingDao.save(rating);
		return rated;
	}

}
