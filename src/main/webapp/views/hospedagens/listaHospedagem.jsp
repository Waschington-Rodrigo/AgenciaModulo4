<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./assets/css/bootstrap.css">
<link rel="stylesheet" href="./assets/css/estilo.css">
<script src="./assets/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<title>Lista de Hospedagens</title>
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

		<img id="fundo" src="./assets/img/fundo.jpg" alt="imagem de fundo">


		<div class="container-fluid opacity">

			<a href="./views/hospedagens/formHospedagem.jsp"
				class="btn btn-primary my-1"><span class="fw-bold">+</span>Hospedagem</a>

			<table class="table table-responsive table-hover">
				<thead class="table-dark">
					<tr class="text-center">
						<th scope="col">Id</th>
						<th scope="col">Nome</th>
						<th scope="col">Valor Diária</th>
						<th scope="col">tipo</th>
						<th scope="col">Estado</th>
						<th scope="col">Cidade</th>
						<th scope="col">telefone</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaHospedagens}" var="hospedagem">
						<tr class="text-center">
							<th scope="row">${hospedagem.id}</th>
							<td>${hospedagem.nome}</td>
							<td>${hospedagem.valorDiaria}</td>
							<td>${hospedagem.tipo}</td>
							<td>${hospedagem.estado}</td>
							<td>${hospedagem.cidade}</td>
							<td>${hospedagem.telefone}</td>
							<td>
								<div class=text-center>
									<a href="./hospedagem-update?id=${hospedagem.id}"
										class="btn btn-success">Editar</a> <a
										href="./hospedagem-delete?id=${hospedagem.id}"
										onclick="return confirm('Deseja Excluir  ${hospedagem.nome}?')"
										class="btn btn-danger">Excluir</a>
								</div>
							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
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