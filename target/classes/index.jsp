<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Enquetes</title>
</head>
<body>
	<h1>Liste des Enquetes</h1>
	<br>
	<c:forEach var="enquete" items="${enquetes}">
		<h2>${enquete.nom}</h2>
		<div>Plannifi&eacute;e le: ${enquete.dateEnqueteString}</div>
		<c:forEach var="question" items="${questions}">
			${question.nom}
			<form action="RemoveQuestion?idQuestion=${question.id}" method="POST">
				<input type="submit" value="Ajouter une question à l'enquête"/>
			</form>
		</c:forEach>
		<form action="AddQuestion?idEnquete=${enquete.id}" method="POST">
			<input type="submit" value="Ajouter une question à l'enquête"/>
		</form>
		<br>
		<form action="RemoveEnquete?idEnquete=${enquete.id}" method="POST">
			<input type="submit" value="Supprimer enquête"/>
		</form>
	</c:forEach>
	<br>
	<br>
	<form action="AddEnqueteServlet" method="GET">
		<input type="submit" value="Ajouter enquête"/>
	</form>
	<br>
	<p>Nombre total d'enquete(s): ${enquetes.size()}</p>
</body>
</html>
