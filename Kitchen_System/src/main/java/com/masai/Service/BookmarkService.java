package com.masai.Service;

import java.util.List;

import com.masai.Exception.BookmarkException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Bookmark;
import com.masai.Model.Recipe;

public interface BookmarkService {
	public Bookmark bookMarkRecipeAssociatedWithUser(String key, Integer recipeId) throws RecipeException, UserException;
	public List<Recipe> getAllBookmarkRecipe(String key) throws RecipeException, UserException, BookmarkException;
}
