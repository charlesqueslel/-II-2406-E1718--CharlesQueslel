<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page d'acceuil</title>
</head>
<body>

	<form method="post" name="f" action="/miniprojet/AuthServlet">

		<fieldset>
		<legend>Connexion</legend>
			<label>Username :
				<input type="text" name="username" placeholder="username">
			</label>
			
			<label>Password :
				<input type="text" name="password" placeholder="password">
			</label>
		</fieldset>
		<input type="submit" value="login">
	</form>
</body>
</html>
