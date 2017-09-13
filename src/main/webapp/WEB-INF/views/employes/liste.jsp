<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste employes</title>
</head>
<body>
Menu :
	<a href="<%=request.getContextPath()%>">Accueil</a>
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Matricule</th>
				<th>Grade</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employes}" var="employe">
				<tr>
					<td>${employe.id}</td>
					<td>${employe.matricule}</td>
					<td>${employe.grade.code}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>