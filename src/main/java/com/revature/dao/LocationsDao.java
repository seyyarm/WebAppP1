package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Location;


import services.ExecutorService;
import services.QueryBuilder;

public class LocationsDao implements LocationsDaoInterface{

	@Override
	public List<Object> getAllLocations() throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		QueryBuilder queryBuilder = new QueryBuilder();
		ExecutorService exec = new ExecutorService(connection);
		
		
		String getQuery = queryBuilder.getColumns("*").fromTable("locations").end();
		
		List<Object> outputList = new ArrayList<Object>();
		
		outputList = exec.getRow(Location.class, getQuery);

		
		for(Object o : outputList) {
			System.out.println(o);
		}

		return outputList;
	}


}
