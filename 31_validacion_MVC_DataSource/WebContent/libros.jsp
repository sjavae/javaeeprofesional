<%@page import="javabeans.Libro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="3">
		<tr><th>Título</th><th>Autor</th><th>Precio</th><th>Páginas</th>
		<%List<Libro> libros=(List<Libro>) request.getAttribute("libros"); 
			for(Libro l:libros){%>
				<tr>
				<td><%=l.getTitulo() %></td>	
				<td><%=l.getAutor() %></td>
				<td><%=l.getPrecio() %></td>
				<td><%=l.getPaginas() %></td>
				</tr>
			<%}%>
	</table>
	<p><a href="temas.jsp">Volver</a></p>
</body>
</html>