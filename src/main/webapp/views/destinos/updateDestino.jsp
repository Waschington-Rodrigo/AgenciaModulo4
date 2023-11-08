<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./assets/css/bootstrap.css">
<link rel="stylesheet" href="./assets/css/estilo.css">
<meta charset="utf-8">
<title>Editar destino</title>
</head>
<body>
	<div class="corpoPagina">
		<jsp:include page="/components/menu.jsp">
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

		<img class="opacity" id="fundo" src="./assets/img/fundo.jpg"
			alt="imagem de fundo">

		<div class="container">
			<form action="./destino-update" class="" method="post">
				<fieldset>
					<legend>Localidade</legend>
					<div>
					<label for="iId" class="form-label">Id:</label>
					<input type="text" class="form-control" id="iId" name="nId" value="${destino.id }" readonly/>
					</div>
					<div class="form-group my-3">
						<label for="iLocalDestino" class="form-label">Local de
							Destino:</label> <input type="text"  id="iLocalDestino"
							name="nLocalDestino" class="form-control" value="${destino.localDestino }" />
					</div>
					<div class="form-group my-3">
						<label for="iValor" class="form-label">Valor:</label> <input
							type="text" id="iValor" name="nValor" class="form-control" value="${destino.valor }" />
					</div>
				</fieldset>
				<fieldset>
					<legend>Logradouro</legend>

					<div class="form-group my-3">
						<label for="iEstado" class="form-label">Estado:</label> <input
							type="text" id="iEstado" name="nEstado" class="form-control"  value="${destino.estado }"/>
					</div>

					<div class="form-group my-3">
						<label for="iCidade" class="form-label">Cidade:</label> <input
							type="text" id="iCidade" name="nCidade" class="form-control" value="${destino.cidade }" />
					</div>
				</fieldset>
				<input type="submit" class="btn btn-primary" value="Atualizar">
				<a href="./destino" class="btn btn-danger">Cancelar</a>
			</form>
		</div>

	</div>
	<footer
		class="text-center text-white fw-bold bg-dark opacity fixed-bottom">
		<div class="row justify-content-center">
			<label class="font-weight-bold" for="">produzido por:</label>
		</div>
		<div class="row justify-content-center">
			<p class="font-weight-light text-monospace ">Waschington Rodrigo</p>
		</div>

	</footer>


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