package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String qualification= req.getParameter("qualification");
			
			UserDao userDao = new UserDao(DBConnect.getConn());
			
			User user = new User(name, email, password, qualification, "User");
			boolean f = userDao.addUser(user);
			
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Registration Successfuly");
				resp.sendRedirect("signup.jsp");
			} else {
				session.setAttribute("succMsg", "Sonething wrong on server");
				resp.sendRedirect("signup.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
