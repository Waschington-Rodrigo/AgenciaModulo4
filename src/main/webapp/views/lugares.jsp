<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/estilo.css">

<title>Lugares</title>
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

		<!--seção com cards com alguns destinos para escolha-->
		<section id="cardDestino" class="container">
			<div class="card-deck my-3">
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Fortaleza-CE</h5>
						<p class="card-text">Conheça as praias de Iracema, Beira-Mar e
							outras. Passeie pelas dunas de areia e muito mais.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
				</div>
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Nova Roma-GO</h5>
						<p class="card-text">Venha ver de perto as mais belas
							cachoeiras da região. Conheça a "Toca-do-macaco e seus atrativos.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
				</div>
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Alto Paraiso-GO</h5>
						<p class="card-text">Lugares como Chapada dos Veadeiros com
							diversas cachoeiras, você só encontra aqui.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
				</div>
			</div>

			<div class="card-deck opacity ">
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Brasilia-DF</h5>
						<p class="card-text">Lago Paranoá, Catedral, Esplanada dos
							Ministérios e a Praça dos Três Poderes são alguns dos atrativos
							do DF.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
				</div>
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Rio de Janeiro-RJ</h5>
						<p class="card-text">Caminhe pelas calçadas de Copacabana e
							conheça praias lindas.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
				</div>
				<div class="card opacity my-3">
					<img class="card-img-top" src="../assets/img/Viajou.com.png"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Manaus-AM</h5>
						<p class="card-text">Teatro Amazonas, Palacio Rio Negro e o
							Museu da Amazônia são lugares que você deve conhecer.</p>
					</div>
					<div class="card-footer">
						<a class="btn btn-sm btn-primary" href="formulario.html">Quero
							Conhecer</a>
					</div>
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