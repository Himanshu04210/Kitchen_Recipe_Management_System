package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
