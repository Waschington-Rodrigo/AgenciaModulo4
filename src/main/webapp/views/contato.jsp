<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/estilo.css">
<title>contato</title>
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

		<!--seção de contatos dentro da pagina-->
		<section id="bodyContato" class="container text-center opacity">
			<table class="table">
				<thead class="row">
					<h5>Aproveite e siga nossas redes sociais:</h5>
				</thead>
				<tbody>
					<tr class="row justify-content-center">


						<td
							class="col col-sm-6 d-flex align-items-center justify-content-end ">
							<img src="../assets/img/logofacebook.png" alt="logo facebook"
							width="50px"> <a target="_blank" href="http://facebook.com">/Viajou.com</a>
						</td>
						<td
							class="col col-sm-6 d-flex align-items-center justify-content-start">
							<img src="../assets/img/logoInstagran.png" alt="logo instagran"
							width="50px"> <a target="_blank"
							href="http://instagram.com">@Viajou.com</a>
						</td>
					</tr>
					<tr class="row justify-content-center">
						<th colspan="2" rowspan="2">
							<h5>Entre em contato através do WhatsApp</h5>
						</th>
					</tr>
					<tr class="row justify-content-center">
						<td class="col col-12"><img
							src="../assets/img/logoWhatsapp.png" alt="logo WhatsApp"
							width="50px"> <a target="_blank"
							href="http://wa.me/5561992090318">(61) 99209-0318</a></td>
					</tr>
					<tr class="row justify-content-center">
						<th class="col col-12">
							<h5>E-mail:</h5>
						</th>
						<td class="col col-12"><img src="../assets/img/logoEmail.png"
							alt="e-mail" width="50px"> <a target="_blank"
							href="mailto:contato@viajou.com"><span id="spanContato">contato@viajou.com</span></a>
						</td>
					</tr>
				</tbody>
			</table>
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