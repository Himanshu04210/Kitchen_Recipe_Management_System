package com.masai.ServiceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CurrentUserSession;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Recipe;
import com.masai.Repository.RecipeDao;
import com.masai.Repository.SessionRepo;
import com.masai.Service.RecipeService;

@Service
public class RecipeServiceImple implements RecipeService{
	
	@Autowired
	private RecipeDao recipeDao;
	

	@Autowired
	private SessionRepo sRepo;

	@Override
	public Recipe addRecipe(String key, Recipe recipe) throws RecipeException, UserException {

		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		
		Recipe savedRecipe = recipeDao.save(recipe);
		
		if(savedRecipe == null) throw new RecipeException("Something went wrong");
		
		return savedRecipe;
	}

	@Override
	public Recipe updateRecipe(String key, Integer recipeId, Recipe recipe) throws RecipeException, UserException {

		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Optional<Recipe> opt = recipeDao.findById(recipeId);
		
		if(opt.isEmpty()) throw new RecipeException("Recipe is present with this recipe id");
		
		Recipe existingRecipe = opt.get();
		
		existingRecipe.setDescription(recipe.getDescription());
		existingRecipe.setDifficultyLevel(recipe.getDifficultyLevel());
		existingRecipe.setIngredients(recipe.getIngredients());
		existingRecipe.setInstrucations(recipe.getInstrucations());
		existingRecipe.setPreparationTime(recipe.getPreparationTime());
		existingRecipe.setTitle(recipe.getTitle());
		
		Recipe updatedRecipe = recipeDao.save(existingRecipe);
		return updatedRecipe;

	}

	@Override
	public Recipe deleteRecipe(String key, Integer recipeId) throws RecipeException, UserException {

		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Optional<Recipe> opt = recipeDao.findById(recipeId);
		
		if(opt.isEmpty()) throw new RecipeException("Recipe is present with this recipe id");

		Recipe existingRecipe = opt.get();
		recipeDao.delete(existingRecipe);
		return existingRecipe;
		
	}

	@Override
	public Recipe getRecipeById(String key, Integer recipeId) throws RecipeException, UserException {
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Optional<Recipe> opt = recipeDao.findById(recipeId);
		
		if(opt.isEmpty()) throw new RecipeException("Recipe is present with this recipe id");
		return opt.get();
	
	}

	@Override
	public List<Recipe> getAllRecipe(String key) throws RecipeException, UserException {
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		List<Recipe> recipes = recipeDao.findAll();
		if(recipes.isEmpty()) throw new RecipeException("No recipe is present");
		return recipes;
		
	}
	
}
