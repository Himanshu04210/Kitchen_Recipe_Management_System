package com.masai.ServiceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.CurrentUserSession;
import com.masai.Exception.BookmarkException;
import com.masai.Exception.RecipeException;
import com.masai.Exception.UserException;
import com.masai.Model.Bookmark;
import com.masai.Model.Recipe;
import com.masai.Repository.BookmarkDao;
import com.masai.Repository.RecipeDao;
import com.masai.Repository.SessionRepo;
import com.masai.Service.BookmarkService;

@Service
public class BookmarkServiceImple implements BookmarkService{

	@Autowired
	private BookmarkDao bookmarkDao;
	
	@Autowired
	private RecipeDao recipeDao;
	@Autowired
	private SessionRepo sRepo;

	@Override
	public Bookmark bookMarkRecipeAssociatedWithUser(String key, Integer recipeId) throws RecipeException, UserException{
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		

		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Integer userId = validCustomerSession.getUserId();
		Optional<Recipe> recipe = recipeDao.findById(recipeId);
		if(recipe.isEmpty()) throw new RecipeException("Recipe is not present with this recipe id");
		
		List<Bookmark> list = bookmarkDao.findByUserId(userId);
		
		for(Bookmark l : list) {
			if(l.getRecipeId() == recipeId) throw new RecipeException("Already bookmarked");
		}
		
		
		Bookmark bookmark = new Bookmark();
		bookmark.setUserId(userId);
		bookmark.setRecipeId(recipeId);
		Bookmark savedObject = bookmarkDao.save(bookmark);
		return savedObject;
	}

	@Override
	public List<Recipe> getAllBookmarkRecipe(String key) throws RecipeException, UserException, BookmarkException {
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		

		if(validCustomerSession == null) {
			throw new UserException("User Not Logged In with this username");
			
		}
		
		Integer userId = validCustomerSession.getUserId();
		
		List<Bookmark> list = bookmarkDao.findByUserId(userId);
		
		if(list.isEmpty()) throw new BookmarkException("No recipe is book mark");
		List<Recipe> recipies = new ArrayList<>();
		
		for(Bookmark b : list) {
			Optional<Recipe> opt  = recipeDao.findById(b.getRecipeId());
			if(opt.isPresent()) recipies.add(opt.get()); 
		}
		
		return recipies;
	}

}
