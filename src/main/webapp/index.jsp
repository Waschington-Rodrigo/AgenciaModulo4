<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="./assets/css/bootstrap.css">
<link rel="stylesheet" href="./assets/css/estilo.css">
<script src="./assets/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="corpoPagina">
		<jsp:include page="./components/menu.jsp">
			<jsp:param value="./" name="home" />
			<jsp:param value="./lugares" name="lugares" />
			<jsp:param value="./promocoes" name="promocoes" />
			<jsp:param value="./contato" name="contatos" />
			<jsp:param value="./usuario" name="usuarios" />
			<jsp:param value="./destino" name="destinos" />
			<jsp:param value="./hospedagem" name="hospedagens" />
			<jsp:param value="./passagem" name="passagens" />
			<jsp:param value="./reserva" name="reservas" />

		</jsp:include>


		<img id="fundo" src="./assets/img/fundo.jpg" alt="imagem de fundo">

		<section id="sectionHome" class="container">

			<!--cards da pagina inicial para navegar pelo menu-->
			<div id="cardHome" class="card my-3">
				<div class="card-header">Lugares Incriveis</div>
				<div class="">
					<img class="card-img-top" src="./assets/img/paredaoCEU.jpg"
						alt="Card image cap">
				</div>

				<div class="card-body opacity">
					<h5 class="card-title">Diversidade é aqui!</h5>
					<p class="card-text ">Conheça diversos locais turísticos e suas
						culturas. Temos aqui uma variedade de locais atrativos com a
						melhor hospedagem</p>
					<a href="./lugares" class="btn btn-primary">Ir agora</a>
				</div>
			</div>
			<div id="cardHome" class="card my-3">
				<div class="card-header">Economize</div>
				<img class="card-img-" src="./assets/img/economia-2.webp"
					alt="Card image cap">

				<div class="card-body opacity">
					<h5 class="card-title">Seu dinheiro rende mais!</h5>
					<p class="card-text">Temos promoções para você. conheça nossos
						pacotes promocionais. Veja onde economizar cada centavo do seu
						bolso.</p>
					<a href="./promocoes" class="btn btn-primary">Ir agora</a>
				</div>
			</div>
			<div id="cardHome" class="card my-3">
				<div class="card-header">Vem conosco</div>
				<img class="card-img-" src="./assets/img/redesSociais.png"
					alt="Card image cap">

				<div class="card-body opacity">
					<h5 class="card-title">Eu te mostro muito mais!</h5>
					<p class="card-text">Entre em nossas redes sociais e viaje na
						sua "telinha". Mostramos pra você, um pouco dessa diversão. Se
						quizer, pode tirar suas dúvidas através do nosso WhatsApp ou
						e-mail. Você escolhe!</p>
					<a href="./contato" class="btn btn-primary">Ir agora</a>
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