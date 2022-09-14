package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;





public interface RoutesDaoInterface {

	//CRUD
	// Get all Locations
		List<Object> getAllRoutes() throws SQLException;
	
	
}
