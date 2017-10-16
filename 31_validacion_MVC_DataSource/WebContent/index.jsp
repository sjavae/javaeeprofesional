<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Formulario de autenticación: </h1>
	<form action="Controller?op=doLogin" method="post">
	<%	String nom="";
	Cookie[] ck=request.getCookies(); 
	if (ck!=null) {
		for(Cookie c:ck){
			 if(c.getName().equals("usrname")){
				nom=c.getValue();
			}
		}
		
	}%>
		<p>User: <input type="text" name="user" value="<%=nom %>" /></p>
		<p>Pass: <input type="password" name="pass" /></p>
		<p><input type="checkbox" name="recordar" value="1" /> Recordar</p>
		<p><input type="submit" value="enviar" /></p>
		<a href="Controller?op=toRegistro">Registrarse</a>
	
	</form>
</body>
</html>

