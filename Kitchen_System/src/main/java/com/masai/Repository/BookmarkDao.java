package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Bookmark;

public interface BookmarkDao extends JpaRepository<Bookmark, Integer>{
	List<Bookmark> findByUserId(Integer userId);
}
