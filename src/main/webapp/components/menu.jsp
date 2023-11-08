<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<nav class="navbar navbar-expand-sm navbar-dark fixed-top">

	<!--botão que abre o menu de navegação do site quando a largura da tela screen for small-->
	<a class="navbar-brand" href="home.html"><img
		src="img/LogoViajou.com.png" alt=""></a>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#como" aria-controls="como" aria-expanded="false"
		aria-label="Altena navegação">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!--Lista de opções do menu de navegação-->
	<div class="collapse navbar-collapse" id="como">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item "><a class="nav-link"
				href=<%=request.getParameter("home")%>> Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href=<%=request.getParameter("lugares")%>>Lugares</a></li>
			<li class="nav-item"><a class="nav-link"
				href=<%=request.getParameter("promocoes")%>>Promoções</a></li>
			<li class="nav-item "><a class="nav-link"
				href=<%=request.getParameter("contatos")%>>Contatos</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"> Controles</a>

				<ul class="dropdown-menu fundo-nav">
					<li><a class="dropdown-item"
						href=<%=request.getParameter("usuarios")%>>Usuários</a></li>
					<li><a class="dropdown-item"
						href=<%=request.getParameter("destinos")%>>Destinos</a></li>
					<li><a class="dropdown-item"
						href=<%=request.getParameter("hospedagens")%>>Hospedagens</a></li>
					<li><a class="dropdown-item"
						href=<%=request.getParameter("passagens")%>>Passagens</a></li>
					<li><a class="dropdown-item"
						href=<%=request.getParameter("reservas")%>>Reservas</a></li>
				</ul></li>
		</ul>
	</div>
</nav>


