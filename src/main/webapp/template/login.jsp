<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="//use.fontawesome.com/releases/v5.0.7/css/all.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container w-50 bg-light bg-opacity-50 mt-5">
		<form method="post" action="/campus_mangement/auth">
			<h3 class="h3 mb-4">Gestionnaire login</h3>
			<input name="email" id="email" type="email"
				placeholder="xyz@email.com" required>
			<input name="password"
				id="password" type="password" placeholder="enter your password"
				required>
			<button class="btn btn-primary my-4 btn-block" type="submit">authentifier</button>
		</form>
	</div>

</body>
</html>