<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Fornitore</title>
</head>
<body>
	<h1>Fornitore</h1>
	<h2>Nome : ${supplier.name}</h2>
	<div>Cognome: ${supplier.surname}</div>
	<div>
		Prodotti :
		<ul>
			<c:forEach var="product" items="${supplier.products}">
				<li><a href="productController?id=${product.id}"> ${product.name} </a></li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<a href="nuovoFornitore.jsp">Indietro</a>
	</div>
</body>
</html>