package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import agencia.DAO.DestinoDAO;
import agencia.model.Destino;
import agencia.model.Hospedagem;

@WebServlet(urlPatterns = { "/promocoes", "/contato", "/lugares" })
public class NavControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
DestinoDAO ddao = new DestinoDAO();
Destino destino = new Destino();
	public NavControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/promocoes":
			pagePromo(request, response);
			break;

		case "/contato":
			pageContato(request, response);
			break;

		case "/lugares":
			pageLugares(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void pagePromo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./views/promocoes.jsp");
	}

	protected void pageContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./views/contato.jsp");
	}

	protected void pageLugares(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Destino> lista = ddao.getDestinos();

		request.setAttribute("listaDestinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/lugares.jsp");
		rd.forward(request, response);
	}
}
