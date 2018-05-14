<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Biblioteca UFAB</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/Footer-Basic.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
<link rel="stylesheet" href="assets/css/Login-Form-Clean.css">
<link rel="stylesheet" href="assets/css/Navigation-Clean.css">
<link rel="stylesheet" href="assets/css/styles.css">
</head>

<body>
	<div class="login-clean">
		
		<form method="post" action="login" data-aos="fade-up"
			data-aos-duration="1000">
			<h2 class="sr-only">Login Form</h2>
			<div class="illustration">
				<i class="fa fa-book"></i>
				<div
					class="d-flex align-items-center align-content-center align-self-center div-name-ufab">
					<h2 class="d-inline-flex">
						<em>Biblioteca</em>
					</h2>
					<h1 class="d-inline-flex">
						<strong>&nbsp;UFAB</strong><br>
					</h1>
				</div>
			</div>
			<c:if test="${param.error}">
				<div class="alert alert-danger" role="alert">Usuário ou senha
					incorreto.</div>
			</c:if>
			<div class="form-group">
				<input class="form-control" type="text" name="username"
					placeholder="Usuário">
			</div>
			<div class="form-group">
				<input class="form-control" type="password" name="password"
					placeholder="Senha">
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">Entrar</button>
			</div>
		</form>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bs-animation.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>