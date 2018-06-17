<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Allievo</title>
</head>
<body>
	<h1>Allievo</h1>
	<h2>Nome : ${supplier.name}</h2>
	<div>Cognome: ${supplier.surname}</div>
	<div>Email: ${supplier.email}</div>
	<div>Telefono: ${supplier.telephone}</div>
	<div>Luogo di Nascita: ${supplier.birthplace}</div>
	<div>Data di Nascita: ${supplier.dateofbirth}</div>
	<div>
		Attività  :
		<ul style="list-style-type:none">
			<c:forEach var="product" items="${supplier.products}">
				<li><a href="productController?id=${product.id}" class ="button button3"> ${product.name} </a></li>
			</c:forEach>
		</ul>
	</div>
	<div>
		<a href="home.jsp" class="button button1">Indietro</a>
	</div>
</body>
</html>