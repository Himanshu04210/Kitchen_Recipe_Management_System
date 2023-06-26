package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Rating;

public interface RatingDao extends JpaRepository<Rating, Integer>{
	List<Rating> findByUserId(Integer userId);
}
