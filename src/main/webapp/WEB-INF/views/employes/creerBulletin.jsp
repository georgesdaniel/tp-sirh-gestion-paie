<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Creation Bulletin</title>
</head>
<body>
	Menu :
	<a href="<%=request.getContextPath()%>">Accueil</a>
	<h1>Ajouter un Bulletin</h1>
	<form method="post" action="<%=request.getContextPath()%>/mvc/employes/validerbulletin">
       Période : <select name = "periodeId">
			<c:forEach var="periode" items="${listePeriodes}">
				<option value="${periode.id}">${periode.dateDebut} - ${periode.dateFin}</option>
			</c:forEach>
		</select>
		<br /> <br />
		<span>Matricule : </span>
			<select name="employeID">
				<c:forEach var="matricule" items="${ListEmployes}">
					<option value="${matricule.id}">${matricule.matricule}</option>
				</c:forEach>
			</select>
		 <br /> <br />		
 		<span>Prime</span>
		 <input type="text" id="prime" name="prime" /> <br />
		<br /> <input type="submit" value="Ajouter" />
	</form>
</body>
</html>