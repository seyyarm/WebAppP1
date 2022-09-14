package com.revature.web;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("userPass");
		
		UserDao userDao = new UserDao();
		try {
			if(userDao.existingUser(userName, passWord)){
				RequestDispatcher rD = request.getRequestDispatcher("welcome");
				
				//Session Handling
				HttpSession session = request.getSession();
				session.setAttribute("user", userName);
				//set max time for session
				session.setMaxInactiveInterval(30*60);
				
				Cookie username1 = new Cookie("user", userName);
				username1.setMaxAge(30*60);
				response.addCookie(username1);
				
				rD.forward(request, response);
				
			} else {
				System.out.println("Failed Login");
				out.println("Username or Password is incorrect");
				RequestDispatcher rD = request.getRequestDispatcher("login.html");
				rD.include(request,response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	} 
}
