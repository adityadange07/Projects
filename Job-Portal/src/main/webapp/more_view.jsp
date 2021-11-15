<%@page import="java.util.ArrayList"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Jobs"%>
<%@page import="com.dao.JobDao"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User : View jobs</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<c:if test="${empty user }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text primary">All Jobs</h5>

				<%
				String category = request.getParameter("category");
				String location = request.getParameter("location");
				String msg = "";

				JobDao jobDao = new JobDao(DBConnect.getConn());
				List<Jobs> list = null;

				if ("none".equals(location) && "none".equals(category)) {
					list = new ArrayList<Jobs>();
					msg = "Jobs Not Availabel";
				} else if ("none".equals(location) || "none".equals(category)) {
					list = jobDao.getJobsByLocationOrCategory(category, location);
				} else {
					list = jobDao.getJobsByLocationAndCategory(category, location);
				}
				
				if (list.isEmpty()) {
					%>
					<h4 class="text-center text-danger">Job Not Available</h4>
					<%
				}

				if (list != null) {

					for (Jobs jobs : list) {
				%>
				<div class="card mt-2">
					<div class=card-body>
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=jobs.getTitle()%></h6>
						<p><%=jobs.getDescription()%></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=jobs.getLocation()%>"readonly">
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=jobs.getCategory()%>"readonly">
							</div>
						</div>
						<h6>
							Publish Date:
							<%=jobs.getPubdate().toString()%></h6>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=jobs.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
						</div>
					</div>
				</div>
				<%
					}
				} else {
					%>
					<h4 class="text-center text-danger"><%=msg%></h4>
					<%
					}
				%>
			</div>
		</div>
	</div>

</body>
</html>