<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>

<p> Nous avons confirm� la r�servation de <jsp:useBean id="rando" type="miniprojet.model.Book" scope="request"/><%= rando.getName() %></p></p>
<form method="post" name="confirme" action="/miniprojet/ResServlet"> <input name="retour" id="retour" value="Retour" type="hidden"><input type="submit" value="Retour"> </form>
<form method="post" name="deco" action="/miniprojet/AuthServlet">
     <input name="deconnect" id="deconnect" value="Deconnecter" type="hidden">
     <input type="submit" value="Se d�connecter"> </form>

</body>
</html>