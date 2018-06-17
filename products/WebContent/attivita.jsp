<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Attività</title>
</head>
<body>
	<h1>Attività</h1>
	<h2>${product.name}</h2>
	<div>Giorno: ${product.day}</div>
	<div>Orario: ${product.time}</div>
	<div>Allievi iscritti :<ul style="list-style-type:none">
		<c:forEach var="supplier" items="${product.suppliers}">
			<li><a href="supplierController?id=${supplier.id}" class="button button3"> ${supplier.name} </a>
			<form action="productController" method="post">
					<input type="hidden" value="${supplier.id}" name="idF" /> 
					<input type="hidden" value="${product.id}" name="id" />
					<input class ="button button2"type="submit" value="Elimina" name="elimina" />
			</form>
			</li>
		</c:forEach>
    </ul>
    </div>
	<div>
	    Iscrivi un allievo :
	<ul style="list-style-type:none">
		<c:forEach var="supplier" items="${suppliers}">
			<li><a href="supplierController?id=${supplier.id}" class="button button3"> ${supplier.name} </a>
			<form action="productController" method="post">
					<input type="hidden" value="${supplier.id}" name="idF" /> 
					<input type="hidden" value="${product.id}" name="id" />
					<input class="button button2" type="submit" value="Iscrivi" name="aggiungi" />
				</form>
			</li>
		</c:forEach>
	</ul>
	</div>
	<a href="home.jsp"class="button button1">Indietro</a>
</body>
</html>