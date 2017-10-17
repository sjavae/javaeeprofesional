<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>registro</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<form action="Controller?op=doRegistro" method="post">
	
	Usuario:<input type="text" name="usuario" />
	<br/>
	Password:<input type="password" name="password"/>
	<br/>
	Email:<input type="text" name="email"/>
	<br/>
	Telefono:<input type="text" name="telefono"/>
	<br/>
	
	<input type="submit" value="Grabar"/>
	<input type="button" onclick=""/>
	
</form>
<form action="Controller?op=toLogin" method="post">
	<input type="submit" value="Cancelar"/>

</form>
</body>
</html>