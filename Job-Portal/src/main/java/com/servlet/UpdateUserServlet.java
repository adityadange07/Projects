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

@WebServlet("/update_profile")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String qualification = req.getParameter("qualification");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			UserDao userDao = new UserDao(DBConnect.getConn());

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setQualification(qualification);
			user.setEmail(email);
			user.setPassword(password);

			boolean f = userDao.updateUser(user);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("succMsg", "Profile Update Successfully");
				resp.sendRedirect("home.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("home.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
