<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Creation employe</title>
</head>
<body>
Menu : <a href="<%=request.getContextPath()%>">Accueil</a>
	<h1>Ajouter un Employé</h1>
	<form method="post" action="<%=request.getContextPath()%>/mvc/employes/inscription">
	 	
		Votre matricule :
		 <input type="text" id="matricule" name="matricule" />
		<br /> <br />
		  Entreprise: <select name="selectentreprises">
		<c:forEach var="entreprise" items="${entreprises}">
				<option value="${entreprise.id}">${entreprise.denomination}</option>
			</c:forEach>
		</select><br /> <br />
		Grade : <select name="selectgrades">
			<c:forEach var="grade" items="${grades}">
				<option value="${grade.id}">${grade.code}</option>
			</c:forEach>
		</select> <br /> <br /><input type="submit" value="Ajouter" />
	</form>
</body>
</html>