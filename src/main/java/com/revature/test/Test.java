package com.revature.test;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ConnectionFactory;
import com.revature.dao.UserDao;
import com.revature.models.Location;
import com.revature.models.Route;
import com.revature.models.User;

import services.ExecutorService;
import services.QueryBuilder;
import services.getLists;




public class Test {

	
	
	public static void main(String[] args) throws SQLException {
		

		
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		
		String getQuery = queryBuilder.getColumns("*").fromTable("routes").end();
		
		List<Object> outputList = new ArrayList<Object>();
		
		outputList = exec.getRow(Route.class, getQuery);

		
		for(Object o : outputList) {
			System.out.println(o);
		}
		
		/*final UserDao userDao = new UserDao();
		List users = new ArrayList();
		users = userDao.getAllUser();
		System.out.println(userDao.getAllUser());
		
		
		
	/*	Connection c = ConnectionFactory.getConnection();
		String query = "Insert into users(username,password,email) values('pikachu','pikachu','pikachu@email.com')";
		Statement statement = c.createStatement();
		statement.execute(query);
		
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		User insertUser = new User(0,"Evan", "evan", "evan@email.com");
		UserDao uDao = new UserDao();
		
		uDao.createUser(insertUser);


		
		//String insertQuery = queryBuilder.insert(insertUser, "users");
		//Object newUser = exec.insert(insertUser, insertQuery);
		System.out.println(insertUser);
		*/
	}

}
