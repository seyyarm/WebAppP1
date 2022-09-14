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

@WebServlet("/listroutes")
public class ListRoutes extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RoutesDao routesDao  = new RoutesDao();
		Route route = new Route();
		List<Object> routesList;
		try {
			routesList = routesDao.getAllRoutes();
	
		PrintWriter out = response.getWriter();
		out.println("<table><tr><td>Route ID</td><td>Name</td><td>Location ID</td><td>Difficulty</td><td>Length</td></tr>");
		for (Object o: routesList) {
			route = (Route) o;
			out.println("<tr><td>");
			out.println(route.getRouteId());
			out.println("</td>");
			out.println("<td>");
			out.println(route.getRouteName());
			out.println("</td>");
			out.println("<td>");
			out.println(route.getLocationId());
			out.println("</td>");
			out.println("<td>");
			out.println(route.getDifficulty());
			out.println("</td>");
			out.println("<td>");
			out.println(route.getLength());
			out.println("</td>");
		} out.println("</tr></table>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("routes");
		dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
