<%@page import="com.dao.JobDao"%>
<%@page import="com.entity.Jobs"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Jobs</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<c:if test="${user.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center txt-primary">All Jobs</h5>

				<c:if test="${not empty succMsg }">
					<div class="alert alert-success" role="alert">${succMsg }</div>
					<c:remove var="succMsg" />
				</c:if>

				<%
				JobDao dao = new JobDao(DBConnect.getConn());
				List<Jobs> list = dao.getAllJobs();
				for (Jobs jobs : list) {
				%>
				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=jobs.getTitle()%></h6>
						<p><%=jobs.getDescription()%></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=jobs.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=jobs.getCategory()%>" readonly>
							</div>
							<div class="form-group col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="Status: <%=jobs.getStatus()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date:
							<%=jobs.getPubdate()%></h6>
						<div class="text-center">
							<a href="edit_jobs.jsp?id=<%=jobs.getId()%>"
								class="btn btn-sm bg-success text-white">Edit</a> <a
								href="delete?id=<%=jobs.getId()%>"
								class="btn btn-sm bg-danger text-white">Delete</a>
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