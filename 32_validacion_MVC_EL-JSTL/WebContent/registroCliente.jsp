<%@page import="servlets.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller?op=doRegistro" method="post">
		<p>Usuario: <input type="text" name="user" /></p>
		<p>Password: <input type="password" name="pass" /></p>
		<p>Email: <input type="text" name="email"/></p>
		<p>Teléfono: <input type="text" name="telefono" /></p>
		<p><input type="submit" value="Enviar" /></p>
	</form>
<%-- 	<p><input type="button" onclick='<jsp:forward page="index.jsp"></jsp:forward>' /></p> --%>

</body>
</html>