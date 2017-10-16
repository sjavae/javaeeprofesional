<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%HttpSession s=request.getSession();
	String user=(String)s.getAttribute("usuario"); %>
	<h1>Bienvenido usuario: <%=user%></h1>
	<p>Tema elegido: <%=request.getParameter("tema")%></p>
	<a href='index.jsp'>Volver</a><p>
	<p><a href='Desconexion'>Desconectar</a><p>
</body>
</html>