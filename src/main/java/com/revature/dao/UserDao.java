package com.revature.dao;

import java.lang.reflect.Field;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.revature.models.User;

import services.ExecutorService;
import services.QueryBuilder;
import services.getLists;






public class UserDao implements UserDaoInterface{

	@Override
	public void createUser(User insertUser) throws SQLException {
		
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		String insertQuery = queryBuilder.insert(insertUser, "users").end();
		Object newUser = exec.insert(insertUser, insertQuery);
		
	}

	@Override
	public List<Object> getAllUser() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		
		String getQuery = queryBuilder.getColumns("*").fromTable("users").end();
		
		List<Object> outputList = new ArrayList<Object>();
		
		outputList = exec.getRow(User.class, getQuery);

		
		for(Object o : outputList) {
			System.out.println(o);
		}

		return outputList;
	}

	
	@Override
	public User readUsernamePass(String userName, String passWord) throws SQLException {
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			QueryBuilder queryBuilder = new QueryBuilder();
			ExecutorService exec = new ExecutorService(connection);
		
		String getQuery = queryBuilder.getColumns("*").fromTable("users").whereEquals("username", userName).andEquals("password", passWord).end();
		User verifyUser = new User();
		List<Object> user = exec.getRow(User.class, getQuery);
		for (Object o: user) {
			verifyUser = (User) o;
		}
		return verifyUser;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		//System.out.println(verifyUser.getUsername());
	
	}

	@Override
	public boolean existingUser(String username, String password) throws SQLException {
		User existUser = this.readUsernamePass(username, password);
		if(existUser.getUserId() == 0) {
			return false;
		} else 
		return true;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}




	


}
