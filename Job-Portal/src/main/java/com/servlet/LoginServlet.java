package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User admin = new User();
			HttpSession session = req.getSession();

			if ("admin@gmail.com".equals(email) && "admin@123".equals(password)) {
				session.setAttribute("user", admin);
				admin.setRole("admin");
				resp.sendRedirect("admin.jsp");
			} else {
				UserDao userDao = new UserDao(DBConnect.getConn());
				User user = userDao.login(email, password);
				if (user != null) {
					session.setAttribute("user", user);
					resp.sendRedirect("home.jsp");
				} else {
					session.setAttribute("succMsg", "Invalid Email & Password");
					resp.sendRedirect("login.jsp");
				}
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
