<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Nuovo Fornitore</title>
</head>
<body>
	<h1>Aggiungi un Fornitore</h1>
	<hr>
	<div align="center">
		<form action="supplierController" method="post">
			<table>
				<tr>
					<td align="right">Nome*:</td>
					<td><input type="text" name="name" 
						autofocus="autofocus"
						value="${supplier.name}" /></td>
					<td>${errName}</td>
				</tr>
				<tr>
					<td align="right">Cognome*:</td>
					<td><input type="text" name="surname"
						value="${supplier.surname}" /></td>
					<td>${errSur}</td>
				</tr>
				<tr>
					<td colspan ="3" align = "center">(* = campo obbligatorio)</td>
				</tr>
			</table>
			<input type="submit" name="submit" value="INVIA" />
		</form>
		<a href = "supplierController">Lista Fornitori</a>
		<a href = "home.jsp">Indietro</a>
	</div>
	
</body>
</html>