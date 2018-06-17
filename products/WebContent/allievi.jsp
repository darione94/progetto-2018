<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Elenco Allievi</title>
</head>
<body>
    <h1>Elenco Allievi </h1>
	<ul style="list-style-type:none">
		<c:forEach var="supplier" items="${suppliers}">
			<li><div><a href="supplierController?id=${supplier.id}" class="button button3"> ${supplier.name} </a>
				<form action="supplierController" method="post">
					<input class="button button2" type="hidden" value="${supplier.id}" name="id" /> 
					<input class="button button2" type="submit" value="cancella" name="delete" />
				</form></div></li>
		</c:forEach>
	</ul>
	<div align="center">
		<form action="supplierController" method="post">
			<input class="button button2" type="submit" value="cancellatutto" name="deleteAll" />
		</form>
		<a href = "home.jsp" class="button button1">Indietro</a>
	</div>
</body>
</html>