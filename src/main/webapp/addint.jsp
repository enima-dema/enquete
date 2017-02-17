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
<h1>Ajouter une enqu�te</h1>
<br>
<form action="AddEnqueteInt" method="POST">
    <input type="text" name="name" placeholder="Nom de l'enqu�te">
    <input type="date" name="date" placeholder="Date de l'enqu�te">
    <input type="number" name="prix" placeholder="Prix">
    <SELECT name="fait">
        <c:forEach items="${faits}" var="f">
            <OPTION value="${f.id}">
                    ${f.nom}
            </OPTION>
        </c:forEach>
    </SELECT>
    <SELECT name="site">
        <c:forEach items="${sites}" var="s">
            <OPTION value="${s.nom}">
                    ${v.name}
            </OPTION>
        </c:forEach>
    </SELECT>
    <br>
    <input type="number" name="quotat" placeholder="Quotat">
    <SELECT name="departement">
        <c:forEach items="${departements}" var="d">
            <OPTION value="${d.code}">
                    ${d.nom}
            </OPTION>
        </c:forEach>
    </SELECT>
    <input type="submit" value="Ajouter enqu�te"/>
</form>
<br>
</body>
</html>
