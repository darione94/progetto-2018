<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Nuovo Allievo</title>
</head>
<body>
	<h1>Nuovo Allievo</h1>
	<hr>
	<div align="center">
		<form action="supplierController" method="post">
			<table>
				<tr>
					<td align="right">Nome:</td>
					<td><input type="text" name="name" 
						autofocus="autofocus"
						value="${supplier.name}" /></td>
					<td>${errName}</td>
				</tr>
				<tr>
					<td align="right">Cognome:</td>
					<td><input type="text" name="surname"
						value="${supplier.surname}" /></td>
					<td>${errSur}</td>
				</tr>
				<tr>
					<td align="right">email:</td>
					<td><input type="text" name="email"
						value="${supplier.email}" /></td>
					<td>${errMail}</td>
				</tr>
				<tr>
					<td align="right">Telefono:</td>
					<td><input type="text" name="telephone"
						value="${supplier.telephone}" /></td>
					<td>${errTel}</td>
				</tr>
				<tr>
					<td align="right">Luogo di Nascita:</td>
					<td><input type="text" name="birthplace"
						value="${supplier.birthplace}" /></td>
					<td>${errBpl}</td>
				</tr>
				<tr>
					<td align="right">Data di Nascita:</td>
					<td><input type="text" name="dateofbirth"
						value="${supplier.dateofbirth}" /></td>
					<td>${errDob}</td>
				</tr>
			</table>
			<input class="button button2" type="submit" name="submit" value="INVIA" />
		</form>
		<a href = "supplierController" class="button button1">Elenco Allievi</a>
		<a href = "home.jsp" class="button button1">Indietro</a>
	</div>
	
</body>
</html>