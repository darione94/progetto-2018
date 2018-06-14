<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Lista Prodotti</title>
</head>
<body>
	<h1>Lista Prodotti</h1>
	<ul style="list-style-type:none">
		<c:forEach var="product" items="${products}">
			<li><a href="productController?id=${product.id}"> ${product.name} </a>
				<form action="productController" method="post">
					<input type="hidden" value="${product.id}" name="id" /> 
					<input type="submit" value="cancella" name="delete" />
				</form></li>
		</c:forEach>
	</ul>
	<div align="center">
		<form action="productController" method="post">
			<input type="submit" value="cancellatutto" name="deleteAll" />
		</form>
		<a href="home.jsp">Indietro</a>
	</div>
</body>
</html>