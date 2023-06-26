package com.masai.Service;

import com.masai.DTO.LongInCrede;
import com.masai.Exception.UserException;
import com.masai.Model.User;

public interface UserService {
	public User RegisterUser(User user) throws UserException;
	public String logIn(LongInCrede crede) throws UserException;
	public String logOutFromAccount(String key)throws UserException;
}
