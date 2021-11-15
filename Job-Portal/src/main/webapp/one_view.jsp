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
<title>User : Single Job</title>
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

				<%
				int id = Integer.parseInt(request.getParameter("id"));
				JobDao jobDao = new JobDao(DBConnect.getConn());
				Jobs jobs = jobDao.getJobById(id);
				%>

				<div class="card">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=jobs.getTitle()%></h6>
						<p><%=jobs.getDescription()%></p>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location: <%=jobs.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category: <%=jobs.getCategory()%>" readonly>
							</div>
						</div>

						<h6>
							Publish Date:
							<%=jobs.getPubdate().toString()%></h6>

					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>