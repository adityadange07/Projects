package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobDao;
import com.db.DBConnect;
import com.entity.Jobs;

@WebServlet("/add_jobs")
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String title = req.getParameter("title");
			String description = req.getParameter("description");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String location = req.getParameter("location");

			Jobs jobs = new Jobs();
			jobs.setTitle(title);
			jobs.setDescription(description);
			jobs.setCategory(category);
			jobs.setStatus(status);
			jobs.setLocation(location);

			HttpSession session = req.getSession();

			JobDao dao = new JobDao(DBConnect.getConn());
			boolean f = dao.addJobs(jobs);
			if (f) {
				session.setAttribute("succMsg", "Job Post Sucessfully");
				resp.sendRedirect("add_jobs.jsp");
			} else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("add_jobs.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
