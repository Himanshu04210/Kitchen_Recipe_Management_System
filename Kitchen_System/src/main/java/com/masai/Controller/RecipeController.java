package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Recipe;
import com.masai.Service.RecipeService;

@RestController
public class RecipeController {
	@Autowired
	private RecipeService recipeService;
	
	
	@PostMapping("recipe/{key}")
	public ResponseEntity<Recipe> addRecipe(@PathVariable("key") String key, @RequestBody Recipe recipe) throws RecipeException, UserException {
		Recipe savedRecipe = recipeService.addRecipe(key, recipe);
		return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
	}
	
	
	@PatchMapping("recipe/{key}/{recipeId}")
	public ResponseEntity<Recipe> updateRecipe(@PathVariable("key") String key, @PathVariable("recipeId") Integer recipeId, @RequestBody Recipe recipe) throws RecipeException, UserException {
		Recipe updatedRecipe = recipeService.updateRecipe(key, recipeId, recipe);
		return new ResponseEntity<>(updatedRecipe, HttpStatus.OK);
	}
	
	@DeleteMapping("recipe/{key}/{recipeId}")
	public ResponseEntity<Recipe> deleteRecipe(@PathVariable("key") String key, @PathVariable("recipeId") Integer recipeId) throws RecipeException, UserException {
		Recipe deletedRecipe = recipeService.deleteRecipe(key, recipeId);
		return new ResponseEntity<>(deletedRecipe, HttpStatus.OK);
	}
	
	@GetMapping("recipe/{key}/{recipeId}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("key") String key, @PathVariable("recipeId") Integer recipeId) throws RecipeException, UserException {
		Recipe recipe = recipeService.getRecipeById(key, recipeId);
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}
	

	@GetMapping("recipe/{key}")
	public ResponseEntity<List<Recipe>> getAllRecipe(@PathVariable("key") String key) throws RecipeException, UserException {
		List<Recipe> recipes = recipeService.getAllRecipe(key);
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}
	
	
}
