<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Marcas disponibles</h3>
	<form method="get" action="show">
		<table border=1 cellspacing=0 cellpadding=4>
			<tr>
				<th>Id</th> 
				<th>Marca</th>
				<th></th>
			</tr>

			<c:forEach var="m" items="${marcas}">
				<tr>
					<td>${m.idMarca}</td>
					<td>${m.nMarca}</td>
					<td><a href="updateMarca/idProd=${m.idMarca}">Actualizar</a>
					<a href="deleteMarca/idProd=${m.idMarca}">Borrar</a>
					</td>
					
				</tr>
			</c:forEach>

		</table>
	</form>

</body>
</html>