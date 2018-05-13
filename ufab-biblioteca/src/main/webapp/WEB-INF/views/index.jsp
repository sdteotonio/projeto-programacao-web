<!DOCTYPE html>
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
	<div>
		<div class="container container-index">
			<div
				class="row justify-content-center align-items-center align-content-center align-self-center"
				style="height: 100vh;">
				<div
					class="col-auto col-md-6 justify-content-center align-items-center align-content-center align-self-center text-center"
					data-aos="fade-right">
					<i class="fa fa-book" style="font-size: 181px; color: #7ab73d;"></i>
					<div
						class="align-items-center align-content-center align-self-center div-name-ufab">
						<h2 class="d-inline-flex">
							<em>Biblioteca</em>
						</h2>
						<h1 class="d-inline-flex">
							<strong>&nbsp;UFAB</strong><br>
						</h1>
					</div>
				</div>
				<div
					class="col-auto col-md-6 justify-content-center align-items-center align-content-center align-self-center text-center"
					data-aos="fade-up" data-aos-duration="1000" data-aos-delay="500">
					<div class="input-group">
						<div class="input-group-prepend"></div>
						<input class="form-control input-search" type="text"
							placeholder="Pesquisar no acervo..." maxlength="50" autofocus="">
						<div class="input-group-append">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<a class="btn btn-primary align-self-end btn-index" type="button"
		data-aos="fade-right" data-aos-duration="1000"
		href="<c:url value='/login' />" data-aos-offset="10"
		style="margin-right: 0px; font-size: 21px; color: #fff;">Acessar
		painel&nbsp;<i class="fa fa-sign-in"></i>
	</a>
	<div class="footer-basic">
		<footer>
			<p class="copyright">UEPB © 2018</p>
		</footer>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/bs-animation.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>

</html>