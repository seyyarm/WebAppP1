package com.revature.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RoutesDao;
import com.revature.models.Route;


@WebServlet("/routes")
public class RoutesServlet extends HttpServlet {

	//private final String rName ="Open Mouths";
	//private final int rId =1;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		//PrintWriter out = response.getWriter();
		//String routeName = request.getParameter("routeName");
		//int routeId = Integer.parseInt(request.getParameter("routeID"));
		
		//routesDao.searchRoute(routeName);
		//routesDao.searchRoute(routeId);
				
		//Stub
		//out.println("Result = " + rName);
		//out.println("Result = " + rId);
		
		
	}
}
