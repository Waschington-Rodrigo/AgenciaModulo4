package controller;

import java.io.IOException;
import java.util.List;

import agencia.DAO.DestinoDAO;
import agencia.model.Destino;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/destino", "/destino-create", "/destino-delete", "/destino-update" })
public class DestinoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DestinoDAO ddao = new DestinoDAO();
	Destino destino = new Destino();

	public DestinoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			listaDestino(request, response);
			break;
		case "/destino-delete":
			deleteDestino(request, response);
			break;

		case "/destino-update":
			updateDestino(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/destino-create":
			createDestino(request, response);
			break;
		case "/destino-update":
			postUpdateDestino(request, response);
			break;
		}
	}

	protected void listaDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Destino> lista = ddao.getDestinos();

		request.setAttribute("listaDestinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/destinos/listadestino.jsp");
		rd.forward(request, response);

	}

	protected void deleteDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ddao.removedById(id);
		response.sendRedirect("destino");
	}

	protected void createDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String valorFormulario = request.getParameter("nValor");
		Float valorParaBanco = Float.parseFloat(valorFormulario.replace(",", "."));
		destino.setLocalDestino(request.getParameter("nLocalDestino"));
		destino.setValor(valorParaBanco);
		destino.setEstado(request.getParameter("nEstado"));
		destino.setCidade(request.getParameter("nCidade"));
		ddao.save(destino);
		response.sendRedirect("./destino");
	}

	protected void updateDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		destino = ddao.getDestinoById(id);

		request.setAttribute("destino", destino);
		RequestDispatcher rd = request.getRequestDispatcher("./views/destinos/updateDestino.jsp");
		rd.forward(request, response);
	}

	protected void postUpdateDestino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String valorFormulario = request.getParameter("nValor");
		Float valorParaBanco = Float.parseFloat(valorFormulario.replace(",", "."));
		
		destino.setValor(valorParaBanco);
		destino.setId(Integer.parseInt(request.getParameter("nId")));
		destino.setCidade(request.getParameter("nCidade"));
		destino.setEstado(request.getParameter("nEstado"));
		destino.setLocalDestino(request.getParameter("nLocalDestino"));
		ddao.update(destino);
		response.sendRedirect("./destino");
	}

}
