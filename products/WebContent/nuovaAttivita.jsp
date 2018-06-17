<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="terminal.css" />
<title>Nuova Attività</title>
</head>
<body>
	<h1>Nuova Attività</h1>
	<hr>
	<div align="center">
		<form action="productController" method="post">
			<table>
				<tr>
					<td align="right">Nome:</td>
					<td><input type="text" name="name" autofocus="autofocus"
						value="${product.name}" /></td>
					<td>${errName}</td>
				</tr>
				<tr>
					<td align="right">Giorno:</td>
					<td><select name="day" >
						<option value="Lunedì">Lunedì</option>
						<option value="Martedì">Martedì</option>
						<option value="Mercoledì">Mercoledì</option>
						<option value="Giovedì">Giovedì</option>
						<option value="Venerdì">Venerdì</option>
						<option value="Sabato">Sabato</option>
						<option value="Domenica">Domenica</option>
						</select></td>
					<td>${errDay}</td>
				</tr>
				<tr>
					<td align="right">Orario:</td>
					<td><select name="time" >
						<option >8.00-9.00</option>
						<option >9.00-10.00</option>
						<option >10.00-11.00</option>
						<option >11.00-12.00</option>
						<option >16.00-17.00</option>
						<option >17.00-18.00</option>
						<option >18.00-19.00</option>
						<option >19.00-20.00</option>
						</select></td>
					
					<td>${errTime}</td>
				</tr>

			</table>
			<input class="button button2" type="submit" name="submit"
				value="INVIA" />
		</form>
		<a href="productController" class="button button1">Elenco Attività</a>
		<a href="home.jsp" class="button button1">Indietro</a>
	</div>

</body>
</html>