<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.JobDao"%>
<%@page import="com.entity.Jobs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Job</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<c:if test="${user.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container p-5">
		<div class="col-md-10 offset-md-1">
			<div class="card p-3">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						JobDao dao = new JobDao(DBConnect.getConn());
						Jobs jobs = dao.getJobById(id);
						%>

						<h5>Edit Jobs</h5>
					</div>
				</div>
				<form action="update" method="post" class="">

					<input type="hidden" value="<%=jobs.getId()%>" name="id">

					<div class="form-group">
						<label>Enter Title</label> <input type="text" name="title"
							required="required" class="form-control"
							value="<%=jobs.getTitle()%>">
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label>location</label> <select name="location"
								class="custom-select" id="inlineFormCustomSelectPref">
								<option value="<%=jobs.getLocation()%>"><%=jobs.getLocation()%></option>
								<option Value="Mumbai">Mumbai</option>
								<option Value="Pune">Pune</option>
								<option Value="Nagpur">Nagpur</option>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label>Category</label> <select class="custom-select"
								id="inlineFormCustomSelectPref" name="category">
								<option value="<%=jobs.getCategory()%>"><%=jobs.getCategory()%></option>
								<option value="IT">IT</option>
								<option value="Developer">Developer</option>
								<option value="Banking">Banking</option>
								<option value="Engineer">Engineer</option>
								<option value="Teacher">Teacher</option>
							</select>
						</div>
						<div class="form-group col-md-4">
							<label>Status</label> <select class="form-control" name="status">
								<option class="Active" value="<%=jobs.getStatus()%>"><%=jobs.getStatus()%></option>
								<option class="Active" value="Active">Active</option>
								<option class="Inactive" value="Inactive">Inactive</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label>Enter Description</label>
						<textarea required="required" rows="6" cols="" name="description"
							class="form-control" value="<%=jobs.getDescription()%>"><%=jobs.getDescription()%></textarea>
					</div>
					<div class="text-center">
						<button class="btn btn-success">Update Job</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>