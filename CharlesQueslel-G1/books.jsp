<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livre</title>
</head>
<body>


<p> Le livre que vous avez recherch� : <jsp:useBean id="rando" type="miniprojet.model.Book" scope="request"/><%= rando.getName() %></p>

<% miniprojet.model.Reservation res = new miniprojet.model.Reservation();
		String reserv = "r�serv�";
		
	if(!res.verifyReserv(rando)){
			reserv = "libre";
			%> 
			<form method="post" name="valide" action="/miniprojet/ResServlet"> 
			<input name="okkk" id="okkk" value="<%= rando.getName()%>" type="hidden">
			<input name="okk" id="okk" value="reserve" type="hidden">
			<input type="submit" value="R�server"> </form>
		
		<%	
		}	
		 %>
<p> Il est <%= reserv %></p>

<form method="post" name="f" action="/miniprojet/ResServlet">

        <fieldset>
        <legend>Rechercher un livre</legend>
            <label>Nom du livre :
                <input type="text" name="bookname" placeholder="titre">
            </label>

        </fieldset>
        <input type="submit">
    </form>
    <form method="post" name="deco" action="/miniprojet/AuthServlet">
     <input name="deconnect" id="deconnect" value="Deconnecter" type="hidden">
     <input type="submit" value="Se d�connecter"> </form>

</form>
</body>
</html>