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
	<c:set var="libros" value="${requestScope.libros}" />
<%-- 	<c:if test="${!empty libros}"> --%>
<c:choose>
	<c:when test="${!empty libros}">
		<table border="1" cellpadding="3">
			<tr>
				<th>Título</th>
				<th>Autor</th>
				<th>Precio</th>
				<th>Páginas</th>
				<c:forEach var="l" items="${libros}">
					<tr>
						<td>${l.titulo}</td>
						<td>${l.autor}</td>
						<td>${l.precio}</td>
						<td>${l.paginas}</td>
					</tr>
				</c:forEach>

				<%-- <%List<Libro> libros=(List<Libro>) request.getAttribute("libros"); 
			for(Libro l:libros){%>
				<tr>
				<td><%=l.getTitulo() %></td>	
				<td><%=l.getAutor() %></td>
				<td><%=l.getPrecio() %></td>
				<td><%=l.getPaginas() %></td>
				</tr>
			<%}%> --%>
		</table>
<%-- 	</c:if> --%>
	</c:when>
	<c:otherwise>
		<h2>No hay libros</h2>
	</c:otherwise>
</c:choose>
	<p>
		<a href="temas.jsp">Volver</a>
	</p>
</body>
</html>