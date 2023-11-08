<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/estilo.css">

<title>promoções</title>
</head>
<body>
	<div class="corpoPagina">
		<jsp:include page="/components/menu.jsp">
			<jsp:param value="../" name="home" />
			<jsp:param value="../lugares" name="lugares" />
			<jsp:param value="../promocoes" name="promocoes" />
			<jsp:param value="../contato" name="contatos" />
			<jsp:param value="../usuario" name="usuarios" />
			<jsp:param value="../destino" name="destinos" />
			<jsp:param value="../hospedagem" name="hospedagens" />
			<jsp:param value="../passagem" name="passagens" />
			<jsp:param value="../reserva" name="reservas" />

		</jsp:include>

		<img id="fundo" src="../assets/img/fundo.jpg" alt="imagem de fundo">

		<!--cards da pagina promoções-->
		<section id="sectionPromo" class="container">

			<div id="cardPromo" class="card my-3">
				<div class="card-header">Pacote Econômico</div>
				<div class="card-body opacity">
					<h5 class="card-title">Economize em tudo</h5>
					<p class="card-text ">Com este pacote você consegue economizar
						até na sua hospedagem. Além do mais, você economiza em passagens,
						viajando em baixa temporada.</p>
					<a href="../reserva-create"
						class="btn btn-primary">Ir agora</a>
				</div>
			</div>
			<div id="cardPromo" class="card my-3">
				<div class="card-header">Pacote Tranquilidade</div>
				<div class="card-body opacity">
					<h5 class="card-title">Eu mereço</h5>
					<p class="card-text">Viajar com um conforto e hospedar em
						hotéis conceituados.</p>
					<a href="../reserva-create"
						class="btn btn-primary">Ir agora</a>
				</div>
			</div>
			<div id="cardPromo" class="card my-3">
				<div class="card-header">Pacote Luxo</div>
				<div class="card-body opacity">
					<h5 class="card-title">Quero o melhor</h5>
					<p class="card-text">Hospedar em hotéis 5 estrelas e viajar na
						classe A.</p>
					<a href="../reserva-create"
						class="btn btn-primary">Ir agora</a>
				</div>
			</div>




		</section>


		<footer
			class="text-center text-white fw-bold bg-dark opacity fixed-bottom">
			<div class="row justify-content-center">
				<label class="font-weight-bold" for="">produzido por:</label>
			</div>
			<div class="row justify-content-center">
				<p class="font-weight-light text-monospace ">Waschington Rodrigo</p>
			</div>

		</footer>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>
</body>
</html>