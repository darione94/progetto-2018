<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Nuova Attività</title>
</head>
<body>
	<h1>Nuova Attività </h1>
	<hr>
	<div align="center">
		<form action="productController" method="post">
			<table>
				<tr>
					<td align="right">Nome*:</td>
					<td><input type="text" name="name" 
						autofocus="autofocus"
						value="${product.name}" /></td>
					<td>${errName}</td>
				</tr>
				<tr>
					<td align="right">Descrizione*:</td>
					<td><input type="text" name="description"
						value="${product.description}" /></td>
					<td>${errDesc}</td>
				</tr>
				<tr>
					<td align="right">Prezzo*:</td>
					<td><input type="text" name="price"
						value="${product.price}" /></td>
					<td>${errPrice}</td>
				</tr>
				<tr>
					<td colspan ="3" align = "center">(* = campo obbligatorio)</td>
				</tr>
			</table>
			<input type="submit" name="submit" value="INVIA" />
		</form>
		<a href = "productController">Lista Prodotti</a>
		<a href = "home.jsp">Indietro</a>
	</div>
	
</body>
</html>