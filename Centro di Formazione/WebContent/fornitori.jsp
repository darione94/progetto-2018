<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Lista Fornitori</title>
</head>
<body>
    <h1>Lista Fornitori </h1>
	<ul style="list-style-type:none">
		<c:forEach var="supplier" items="${suppliers}">
			<li><div><a href="supplierController?id=${supplier.id}"> ${supplier.name} </a>
				<form action="supplierController" method="post">
					<input type="hidden" value="${supplier.id}" name="id" /> <input
						type="submit" value="cancella" name="delete" />
				</form></div></li>
		</c:forEach>
	</ul>
	<div align="center">
		<form action="supplierController" method="post">
			<input type="submit" value="cancellatutto" name="deleteAll" />
		</form>
		<a href = "home.jsp">Indietro</a>
	</div>
</body>
</html>