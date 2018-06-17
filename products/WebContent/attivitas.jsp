<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Elenco Attività</title>
</head>
<body>
	<h1>Elenco Attività</h1>
	<ul style="list-style-type:none">
		<c:forEach var="product" items="${products}">
			<li><a href="productController?id=${product.id}" class="button button3"> ${product.name} </a>
				<form action="productController" method="post">
					<input type="hidden" value="${product.id}" name="id" /> 
					<input class="button button2" type="submit" value="cancella" name="delete" />
				</form></li>
		</c:forEach>
	</ul>
	<div align="center">
		<form action="productController" method="post">
			<input class="button button2" type="submit" value="cancellatutto" name="deleteAll" />
		</form>
		<a href="home.jsp" class="button button1">Indietro</a>
	</div>
</body>
</html>