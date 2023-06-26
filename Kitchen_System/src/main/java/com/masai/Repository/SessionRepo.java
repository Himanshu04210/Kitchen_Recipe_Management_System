package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.DTO.CurrentUserSession;

public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	public  CurrentUserSession  findByUuid(String uuid);
}
