package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.BookmarkException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Bookmark;
import com.masai.Model.Recipe;
import com.masai.Service.BookmarkService;

@RestController
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;
	
	
	@PostMapping("/bookmark/{key}/{recipeId}")
	public ResponseEntity<Bookmark> bookmarkRecipe(@PathVariable("key") String key, @PathVariable("recipeId") Integer recipeId) throws UserException, RecipeException {
		
		Bookmark savedObject = bookmarkService.bookMarkRecipeAssociatedWithUser(key, recipeId);
		
		return new ResponseEntity<Bookmark>(savedObject, HttpStatus.CREATED);
	}
	

	@GetMapping("/bookmark/{key}")
	public ResponseEntity<List<Recipe>> bookmarkRecipe(@PathVariable("key") String key) throws UserException, RecipeException, BookmarkException {
		
		List<Recipe> list = bookmarkService.getAllBookmarkRecipe(key);
		
		return new ResponseEntity<>(list, HttpStatus.CREATED);
	}
}
