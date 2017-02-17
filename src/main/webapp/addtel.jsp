<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Liste des Enquetes</title>
</head>
<body>
<h1>Ajouter une enquête</h1>
<br>
<form action="AddEnquete" method="POST">
    <input type="text" name="name" placeholder="Nom de l'enquête">
    <input type="date" name="date" placeholder="Date de l'enquête">
    <input type="number" name="prix" placeholder="Prix">
    <c:forEach items="${faits}" var="f">
        <OPTION value="${f.id}">
                ${f.name}
        </OPTION>
    </c:forEach>
    <textarea rows="4" cols="50" name="accroche"></textarea>
    <br>
    <input type="number" name="quotat" placeholder="Quotat">
    <c:forEach items="${departements}" var="d">
        <OPTION value="${d.code}" name="departement">
                ${d.nom}
        </OPTION>
    </c:forEach>
    <c:forEach items="${faits}" var="f">
        <OPTION value="${f.id}" name="fait">
                ${f.nom}
        </OPTION>
    </c:forEach>
    <input type="submit" value="Ajouter enquête"/>
</form>
<br>
</body>
</html>
