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
		<c:forEach var="question" items="${enquete.questions}">
			${question.nom}
			<form action="RemoveQuestion?idQuestion=${question.id}" method="POST">
				<input type="submit" value="Ajouter une question � l'enqu�te"/>
			</form>
		</c:forEach>
		<form action="AddQuestion?idEnquete=${enquete.id}" method="POST">
			<input type="submit" value="Ajouter une question � l'enqu�te"/>
		</form>
		<br>
		<form action="RemoveEnquete?idEnquete=${enquete.id}" method="POST">
			<input type="submit" value="Supprimer enqu�te"/>
		</form>
	</c:forEach>
	<br>
	<br>
	<form action="AddEnqueteInt" method="GET">
		<input type="submit" value="Ajouter enqu�te INTERNET"/>
	</form>
	<form action="AddEnqueteTel" method="GET">
		<input type="submit" value="Ajouter enqu�te TELEPHONIQUE"/>
	</form>
	<br>
	<p>Nombre total d'enquete(s): ${enquetes.size()}</p>
</body>
</html>
