<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Formulario de autenticaci�n: </h1>
	<form action="Controller?op=doLogin" method="post">
		<p>User: <input type="text" name="user" value="${cookie.usrname.value}" /></p>
		<p>Pass: <input type="password" name="pass" /></p>
		<p><input type="checkbox" name="recordar" value="1" /> Recordar</p>
		<p><input type="submit" value="enviar" /></p>
		<a href="Controller?op=toRegistro">Registrarse</a>
	</form>
</body>
</html>

