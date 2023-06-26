package com.masai.Service;

import java.util.List;

import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Recipe;

public interface RecipeService {
	public Recipe addRecipe(String key, Recipe recipe) throws RecipeException, UserException;
	public Recipe updateRecipe(String key, Integer recipeId, Recipe recipe) throws RecipeException, UserException;
	public Recipe deleteRecipe(String key, Integer recipeId) throws RecipeException, UserException;
	public Recipe getRecipeById(String key, Integer recipeId)throws RecipeException, UserException;
	public List<Recipe> getAllRecipe(String key) throws RecipeException, UserException;
}
