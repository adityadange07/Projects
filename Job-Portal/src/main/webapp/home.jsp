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

				<c:if test="${not empty succMsg }">
					<h4 class="text-center text-danger">${succMsg }</h4>
					<c:remove var="succMsg" />
				</c:if>

				<div class="card">
					<div class="card-body">
						<form class="form-inline" action="more_view.jsp" method="get">
							<div class="form-group col-md-5 mt-1">
								<h5>Location</h5>
							</div>

							<div class="form-group col-md-4 mt-1">
								<h5>Category</h5>
							</div>

							<div class="form-group col-md-5">
								<select name="location" class="custom-select"
									id="inlineFormCustomSelectPref">
									<option selected value="none">Choose...</option>
									<option Value="Mumbai">Mumbai</option>
									<option Value="Pune">Pune</option>
									<option Value="Nagpur">Nagpur</option>
								</select>
							</div>

							<div class="form-group col-md-5">
								<select class="custom-select" id="inlineFormCustomSelectPref"
									name="category">
									<option selected value="none">Choose...</option>
									<option value="IT">IT</option>
									<option value="Developer">Developer</option>
									<option value="Banking">Banking</option>
									<option value="Engineer">Engineer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>

							<button class="btn btn-success">Submit</button>

						</form>
					</div>
				</div>

				<%
				JobDao jobDao = new JobDao(DBConnect.getConn());
				List<Jobs> list = jobDao.getAllJobsForUser();
				for (Jobs jobs : list) {
				%>
				<div class="card mt-2">
					<div class=card-body>
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=jobs.getTitle()%></h6>

						<%
						if (jobs.getDescription().length() > 0 && jobs.getDescription().length() < 120) {
						%>
						<p><%=jobs.getDescription()%></p>
						<%
						} else {
						%>
						<p><%=jobs.getDescription().substring(0, 120)%></p>
						<%
						}
						%>
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
				%>
			</div>
		</div>
	</div>

</body>
</html>