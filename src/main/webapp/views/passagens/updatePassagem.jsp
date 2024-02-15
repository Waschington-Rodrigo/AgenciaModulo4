<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script>
function getDestino(param){
	location.href=param;
}
</script>
<link rel="stylesheet" href="./assets/css/bootstrap.css">
<link rel="stylesheet" href="./assets/css/estilo.css">
<meta charset="utf-8">
<title>formulario para Passagens</title>
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
			<form action="./passagem-update" class="" method="post">
				<fieldset>
					<legend>Pacote Promocional</legend>
					<div class="form-group my-3">

						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="nPacotePromo"
								id="iPacotePromo1" value="1" checked> <label
								class="form-check-label font-weight-bold" for="iPacotePromo1">
								Pacote Economica </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="nPacotePromo"
								id="iPacotePromo2" value="2"> <label
								class="form-check-label font-weight-bold" for="iPacotePromo2">
								Pacote Tranquilidade </label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" name="nPacotePromo"
								id="iPacotePromo3" value="3"> <label
								class="form-check-label font-weight-bold" for="iPacotePromo3">
								Pacote Luxo </label>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Dados para Compra</legend>
					<div class="form-group my-3">
						<label for="iId" class="form-label">Id:</label> <input
							type="text" id="iId" name="nId" value="${passagem.id}" class="form-control" readonly />
					</div>

					<div class="form-group my-3">
						<label for="iDataViagem" class="form-label">Data da Viagem:</label> <input
							type="date" id="iDataViagem" name="nDataViagem" class="form-control" value="${passagem.dataViagem}" />
					</div>

					<div class="form-group my-3">
						<label for="iCPFUsuario" class="form-label">CPF:</label> <input
							type="text" id="iCPFUsuario" name="nCpfUsuario" class="form-control"  value="${passagem.usuario.cpf}" placeholder="É necessario ter cadastro de usuario, para realizar compras!"/>
					</div>
					
					<div class="form-group my-3">
						<label for="iDestino" class="form-label">Destino:</label>
						<select id="iDestino" name="nDestino">
						<c:forEach items="${listaDestinos }" var="destino">
						<option value="${destino.id }">${destino.localDestino} / ${destino.cidade }</option>
						</c:forEach>
						</select>
					</div>
					
					
					
				</fieldset>
				<input type="submit" class="btn btn-primary" value="Atualizar">
				<a href="./passagem" class="btn btn-danger">Cancelar</a>
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