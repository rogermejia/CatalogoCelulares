<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo de productos</title>

<style>
#nohay {
	background-color:#F04B4B;
}

#hay {
	background-color: white;
}
</style>

<link href="src/main/webapp/WEB-INF/resources/materialize.js" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="redir">	
	<table>
	<tr>
	<td><input type="submit" name="m" value="Marcas"/></td>
	<td><input type="submit" name="pv" value="Proveedores"/></td>
	<td><input type="submit" name="pr" value="Productos"/></td>
	</tr>
	</table>
</form>




<br></br>
<h3>Registrar Productos</h3>
	<form method="post" action="addProd">
		<table>

			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" /></td>
			</tr>

			<tr>
				<td>Marca</td>
				<td><input type="text" name="idMarca" /></td>
			</tr>

			<tr>
				<td>Precio</td>
				<td><input type="text" name="precio" placeholder="0.00" /></td>
			</tr>

			<tr>
				<td>Descripción</td>
				<td><input type="text" name="descrip" /></td>
			</tr>


			<tr>
				<td>Stock</td>
				<td><input type="text" name="stock" /></td>
			</tr>


		</table>
		<input type="submit" name="g" value="Guardar" />
	</form>
	<br></br>

	<h3>Productos en tienda</h3>
	<form method="get" action="show">
		<table border=1 cellspacing=0 cellpadding=4>
			<tr>
				<th>Id</th> 
				<th>Nombre</th>
				<th>Marca</th>
				<th>Precio</th>
				<th>Descripción</th>
				<th>Stock</th>
				<th></th>
			</tr>

			<c:forEach var="p" items="${productos}">
		
				<tr>
					<td>${p.idProd}</td>
					<td>${p.nombre}</td>
					<td>${p.id_marca.nMarca}</td>
					<td>${p.precio}</td>
					<td>${p.descrip}</td>
					<td style="${c.color}">${p.stock}</td>
					<td><a href="updateDato/idProd=${p.idProd}">Actualizar</a>
					<a href="deleteDato/idProd=${p.idProd}">Borrar</a>
					</td>
					
				</tr>
			
			</c:forEach>

		</table>
	</form>

</body>

</html>
