<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>

	<center>
            <h1>Seleccione Tema</h1>
            <br/><br/>
		<form  action="Controller?op=doLibros" method="post">
			<select name="tema">
				<option value="0">Todos</option>
				<c:set var="temas" value="${requestScope.temas}"/>
				<c:forEach var="t" items="${temas}">
					<option value="${t.idTema}">${t.tema}</option>				
				</c:forEach>
				<%-- 
					<%List<Tema> temas=(List<Tema>)request.getAttribute("temas");
					for(Tema t:temas){%>
					
						<option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>
					<%}%>
				--%>
			</select>
			<br/>
			<input type="submit" value="Ver libros"/>
			
		</form>

	
	</center>

</body>
</html>