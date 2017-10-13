<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.GestionTemas"%>
<%@page import="modelo.GestionClientes"%>
<%@page import="javabeans.Tema"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Controller?op=doLibros" method="post">
		<select name="tema">
			<option value="0">Todos</option>
			<%
				GestionTemas gtemas = new GestionTemas();
				List<Tema> tema = gtemas.RecuperarTemas();
				for (Tema t : tema) {
			%>
			<option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>
			<%
				}
			%>
		</select>
		<input type="submit" value="Ver libros"/>
	</form>
	<p>
		<a href="Controller?op=toLogin">Volver</a>
	</p>

</body>
</html>
