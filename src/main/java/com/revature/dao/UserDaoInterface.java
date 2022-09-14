package com.revature.dao;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.revature.models.User;





public interface UserDaoInterface {

	//Add User
	public void createUser(User insertUser) throws SQLException;
	
	//Display all Users
	List<Object> getAllUser() throws SQLException;
	
	//Read username
	User readUsernamePass(String userName, String passWord)  throws SQLException;
	
	//If User exist
	boolean existingUser(String username, String password) throws SQLException;
	
	//Delete User
	void deleteUser(User user);
}
