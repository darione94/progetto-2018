<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Prodotto</title>
</head>
<body>
	<h1>Prodotto</h1>
	<h2>${product.name}</h2>
	<div>Descrizione: ${product.description}</div>
	<div>Prezzo: ${product.price}</div>
	<div>Forntitori :<ul>
		<c:forEach var="supplier" items="${product.suppliers}">
			<li><a href="supplierController?id=${supplier.id}"> ${supplier.name} </a>
			<form action="productController" method="post">
					<input type="hidden" value="${supplier.id}" name="idF" /> 
					<input type="hidden" value="${product.id}" name="id" />
					<input type="submit" value="Elimina" name="elimina" />
			</form>
			</li>
		</c:forEach>
    </ul>
    </div>
	<div>
	    Aggiungi un Fornitore :
	<ul>
		<c:forEach var="supplier" items="${suppliers}">
			<li><a href="supplierController?id=${supplier.id}"> ${supplier.name} </a>
			<form action="productController" method="post">
					<input type="hidden" value="${supplier.id}" name="idF" /> 
					<input type="hidden" value="${product.id}" name="id" />
					<input type="submit" value="Aggiungi" name="aggiungi" />
				</form>
			</li>
		</c:forEach>
	</ul>
	</div>
	<a href="nuovoProdotto.jsp">Indietro</a>
</body>
</html>