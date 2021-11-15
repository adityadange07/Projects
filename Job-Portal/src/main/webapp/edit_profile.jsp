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
<title>Edit Profile</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<c:if test="${empty user }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card p-3">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Jobs</h5>
						</div>
					</div>
					<form action="update_profile" method="post">

						<input type="hidden" value="${user.id }" name="id">

						<div class="form-group">
							<label>Enter Full Name</label> <input type="text" name="name"
								required="required" class="form-control" value="${user.name }">
						</div>

						<div class="form-group">
							<label>Enter Qualification</label> <input type="text"
								name="qualification" required="required" class="form-control"
								value="${user.qualification }">
						</div>

						<div class="form-group">
							<label>Enter Email</label> <input type="email" name="email"
								required="required" class="form-control" value="${user.email }">
						</div>

						<div class="form-group">
							<label>Enter Full Name</label> <input type="password"
								name="password" required="required" class="form-control"
								value="${user.password }">
						</div>

						<button type="submit" class="btn btn-primary badge-pill btn-block">Update</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>