<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Bulletin</title>
</head>
<body>
Menu :
	<a href="<%=request.getContextPath()%>">Accueil</a>
	<table class="table">
		<thead>
			<tr>
				<th>Date/heure de création |</th>
				<th>Période |</th>
				<th>Matricule |</th>
				<th>Salaire brut |</th>
				<th>Net imposable |</th>
				<th>Net à payer |</th>
				<th>Actions |</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ListBulletins}" var="bulletin">
				<tr>
					<td>${bulletin.dateCreation}</td>
					<td>${bulletin.periode.dateDebut} - ${bulletin.periode.dateFin}</td>
					<td>${bulletin.remunerationEmploye.matricule}</td>
					<td>A calculer </td>
					<td>A calculer </td>
					<td>A calculer </td>
					<td>Visualiser </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>