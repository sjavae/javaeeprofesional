
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    
<c:set var="libros" value="${requestScope.libros}"/>
<c:set var="carrito" value="${requestScope.carritos}"/>
<c:set var="cliente" value="${requestScope.clientes}"/>
<c:choose>
	<c:when test="${!empty libros}">
		<table border="1">
		    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>
		    	
		    	<c:forEach var="lib" items="${libros}">
		    		<tr>
		    			<td>${lib.titulo}</td>
						<td>${lib.autor}</td>
						<td>${lib.precio}</td>
						<td><a href="Controller?op=doComprar&isbn=${lib.isbn}&tema=0" >Comprar</a></td>
					</tr>
		    	
		    	</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2>No hay libros</h2>
	</c:otherwise>
</c:choose>
<br/><br/>
<a href="TemasAction" >Elige nuevo tema</a>
<br/><br/>
<c:choose>
	<c:when test="${!empty carrito}">
		<table border="1">
		    <tr><th>Eliminar</th><th>Titulo</th><th>Autor</th><th>Precio</th></tr>
		    	<c:forEach var="car" items="${carritos}">
		    		<tr>
		    			<td><a href="Controller?op=doEliminar&isbn=${car.isbn}&tema=0" >Eliminar</a></td>
		    			<td>${car.titulo}</td>
						<td>${car.autor}</td>
						<td>${car.precio}</td>
					</tr>
		    	</c:forEach>
		</table>
		
	<br/><br/>
	<a href="Controller?op=doEliminarTodo&cliente&user=${requestScope.user}">Vaciar Carrito</a>
	</c:when>
	<c:otherwise>
		<h2>El carrito está vacío</h2>
	</c:otherwise>
</c:choose>
<br/><br/>
<a href="Controller?op=doComprarTodo&user=${requestScope.user}">Finalizar Compra</a>
<br/><br/>
<a href="Controller?op=toLogin">Inicio</a>

</body>
</html>