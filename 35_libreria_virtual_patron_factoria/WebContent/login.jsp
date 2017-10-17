<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="Controller?op=doLogin" method="POST">
		 
		
			Usuario:<input type="text" name="user" value="${cookie.user.value}"/><br/>
			Contraseña:<input type="password" name="pwd"/><br/>
			Recordar:<input type="checkbox" name="recordar" value="1"/>
			<br/>
			<input type="submit" value="Enviar"/><br/>
		</form>
		<br/>
		<a href="Controller?op=toRegistro">Registrese</a>
	</center>

</body>
</html>