<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img { //
	background: url("img/logo.png");
	background-color: #bbe4e9;
	width: 100%;
	height: 91.5vh; //
	background-repeat: no-repeat; //
	background-size: cover;
	width: 100%;
}
</style>
</head>
<body style="background-color: #f7f7f7;">

	<c:if test="${user.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	<%@include file="all_component/navbar.jsp"%>
	<div class="contaier-fluid back-img">
		<div class="text-center">
			<h1 class="text-white p-4">Welcome Admin</h1>
		</div>
	</div>
</body>
</html>