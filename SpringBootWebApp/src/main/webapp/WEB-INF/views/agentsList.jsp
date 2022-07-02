<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#rcorners1 {
	border-radius: 25px;
	background: #73AD21;
	padding: 20px;
	width: 200px;
	height: 150px;
}

* {
	box-sizing: border-box;
}

body {
	margin: 0;
}

/* Style the header */
.header {
	background-color: #f1f1f1;
	padding: 20px;
	text-align: center;
}

/* Style the top navigation bar */
.topnav {
	overflow: hidden;
	background-color: #333;
}

/* Style the topnav links */
.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
	background-color: #ddd;
	color: black;
}

/* Create three equal columns that floats next to each other */
.column {
	float: left;
	width: 33.33%;
	padding: 15px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
	.column {
		width: 100%;
	}
}
</style>
</head>
<body>

	<div class="header">
		<h1>Surger Insure</h1>

	</div>

	<jsp:include page="navbar.jsp" />

	<div class="row">
		<div class="column"></div>

		<div class="column">
			<h1>Agents List</h1>
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>City</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="emp" items="${agent}">
					<tr>
						<td>${emp.agentId}</td>
						<td>${emp.agentFirstName}</td>
						<td>${emp.agentLastName}</td>
						<td>${emp.agentEmailId}</td>
						<td>${emp.agentcity}</td>
						<td><a href="getEditAgentPage/${emp.agentId}">Edit</a></td>
						<td><a href="deleteAgent/${emp.agentId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<div class="column"></div>
	</div>

</body>

</html>