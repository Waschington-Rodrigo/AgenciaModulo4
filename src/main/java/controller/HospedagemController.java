package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import agencia.DAO.HospedagemDAO;
import agencia.model.Hospedagem;

@WebServlet(urlPatterns = { "/hospedagem", "/hospedagem-create", "/hospedagem-delete", "/hospedagem-update" })
public class HospedagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HospedagemDAO hdao = new HospedagemDAO();
	Hospedagem hospedagem = new Hospedagem();
	

	public HospedagemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/hospedagem":
			listaHospedagem(request, response);
			break;
		case "/hospedagem-delete":
			deleteHospedagem(request, response);
			break;

		case "/hospedagem-update":
			updateHospedagem(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/hospedagem-create":
			createHospedagem(request, response);
			break;
		case "/hospedagem-update":
			postUpdateHospedagem(request, response);
			break;
		}
	}

	protected void listaHospedagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Hospedagem> lista = hdao.getHospedagens();

		request.setAttribute("listaHospedagens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/hospedagens/listaHospedagem.jsp");
		rd.forward(request, response);

	}

	protected void deleteHospedagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		hdao.removedById(id);
		response.sendRedirect("hospedagem");
	}

	protected void createHospedagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String valorFormulario = request.getParameter("nValorDiaria");
		double valorParaBanco = Double.parseDouble(valorFormulario.replace(",", "."));
		hospedagem.setNome(request.getParameter("nNome"));
		hospedagem.setTipo(request.getParameter("nTipo"));
		hospedagem.setValorDiaria(valorParaBanco);
		hospedagem.setTelefone(request.getParameter("nTelefone"));
		hospedagem.setEndereco(request.getParameter("nEndereco"));
		hospedagem.setEstado(request.getParameter("nEstado"));
		hospedagem.setCidade(request.getParameter("nCidade"));
		hdao.save(hospedagem);
		response.sendRedirect("./hospedagem");
	}

	protected void updateHospedagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		hospedagem = hdao.getHospedagemById(id);

		request.setAttribute("hospedagem", hospedagem);
		RequestDispatcher rd = request.getRequestDispatcher("./views/hospedagens/updateHospedagem.jsp");
		rd.forward(request, response);
	}

	protected void postUpdateHospedagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String valorFormulario = request.getParameter("nValorDiaria");
		double valorParaBanco = Double.parseDouble(valorFormulario.replace(",", "."));

		hospedagem.setId(Integer.parseInt(request.getParameter("nId")));
		hospedagem.setNome(request.getParameter("nNome"));
		hospedagem.setTipo(request.getParameter("nTipo"));
		hospedagem.setValorDiaria(valorParaBanco);
		hospedagem.setTelefone(request.getParameter("nTelefone"));
		hospedagem.setEndereco(request.getParameter("nEndereco"));
		hospedagem.setEstado(request.getParameter("nEstado"));
		hospedagem.setCidade(request.getParameter("nCidade"));
		hdao.update(hospedagem);
		response.sendRedirect("./hospedagem");
	}

}
