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
	<form method="post" action="updateProd">
		<table>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Marca</td>
				<td>Precio</td>
				<td>Descripción</td>
				<td>Stock</td>
			</tr>
			<c:forEach var="p" items="${productos}">
				<tr>
					<td readonly="">${d.idProd}</td>
					<td>${p.nombre}</td>
					<td>${p.id_marca.nMarca}</td>
					<td>${p.precio}</td>
					<td>${p.descrip}</td>
					<td>${p.stock}</td>
					<td><a href="doneProd/idProd=${p.idProd}">Actualizar</a></td>

				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>