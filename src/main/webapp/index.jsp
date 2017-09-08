<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAIE</title>
</head>
<body>
<h1>SIRH - Gestion de la paie</h1>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<h2>Menu Gestion de paie</h2>
<ul>
<li><a href="<%=request.getContextPath()%>/mvc/employes/creer">Ajouter un employé</a></li>
<li><a href="">Liste des employés</a></li>
<li><a href="">Créer un bulletin de salaire</a></li>
<li><a href="">Liste des bulletins</a></li>
</ul>
</body>
</html>