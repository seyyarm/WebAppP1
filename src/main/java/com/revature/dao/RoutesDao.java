package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.revature.models.Route;


import services.ExecutorService;
import services.QueryBuilder;







public class RoutesDao implements RoutesDaoInterface{

	@Override
	public List<Object> getAllRoutes() throws SQLException {
		
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		
		String getQuery = queryBuilder.getColumns("*").fromTable("routes").end();
		
		List<Object> outputList = new ArrayList<Object>();
		
		outputList = exec.getRow(Route.class, getQuery);

		
		for(Object o : outputList) {
			System.out.println(o);
		}

		return outputList;
	}
	
	

}
