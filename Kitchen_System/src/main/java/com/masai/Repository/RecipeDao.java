package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Recipe;

public interface RecipeDao extends JpaRepository<Recipe, Integer>{

}
