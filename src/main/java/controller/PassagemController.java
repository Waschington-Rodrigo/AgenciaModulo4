package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import agencia.DAO.DestinoDAO;
import agencia.DAO.PassagemDAO;
import agencia.DAO.UsuarioDAO;
import agencia.model.Destino;
import agencia.model.Passagem;
import agencia.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/passagem", "/passagem-create", "/passagem-delete", "/passagem-update" })
public class PassagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PassagemDAO pdao = new PassagemDAO();
	Passagem passagem = new Passagem();
	Usuario usuario = new Usuario();
	UsuarioDAO udao = new UsuarioDAO();
	Destino destino = new Destino();
	DestinoDAO ddao = new DestinoDAO();

	SimpleDateFormat simpleData = new SimpleDateFormat("yyyy-MM-dd");
	Date dataParaBanco = new Date();

	public PassagemController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/passagem":
			listaPassagem(request, response);
			break;
		case "/passagem-delete":
			deletePassagem(request, response);
			break;

		case "/passagem-update":
			updatePassagem(request, response);
			break;

		case "/passagem-create":
			createPassagem(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/passagem-create":
			postCreatePassagem(request, response);
			break;
		case "/passagem-update":
			postUpdatePassagem(request, response);
			break;
		}
	}

	protected void listaPassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Passagem> lista = pdao.getPassagens();

		request.setAttribute("listaPassagens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/listaPassagem.jsp");
		rd.forward(request, response);

	}

	protected void deletePassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pdao.removedById(id);
		response.sendRedirect("passagem");
	}

	protected void createPassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Destino> lista = ddao.getDestinos();

		request.setAttribute("listaDestinos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/formPassagem.jsp");
		rd.forward(request, response);
		
	}

	protected void updatePassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		passagem = pdao.getPassagemById(id);

		List<Destino> lista = ddao.getDestinos();

		request.setAttribute("listaDestinos", lista);
		request.setAttribute("passagem", passagem);
		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/updatePassagem.jsp");
		rd.forward(request, response);
	}

	protected void postUpdatePassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("nCpfUsuario");
		usuario = udao.getUsuarioByCPF(cpf);

		int idDestino = Integer.parseInt(request.getParameter("nDestino"));
		destino = ddao.getDestinoById(idDestino);

		String dataFormulario = request.getParameter("nDataViagem");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passagem.setId(Integer.parseInt(request.getParameter("nId")));
		passagem.setDataViagem(dataParaBanco);
		passagem.setDestino(destino);
		passagem.setUsuario(usuario);
		passagem.setPacotePromo(Integer.parseInt(request.getParameter("nPacotePromo")));
		pdao.update(passagem);

		response.sendRedirect("./passagem");
	}

	protected void postCreatePassagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("nCpfUsuario");
		usuario = udao.getUsuarioByCPF(cpf);

		int id = Integer.parseInt(request.getParameter("nDestino"));
		destino = ddao.getDestinoById(id);

		String dataFormulario = request.getParameter("nDataViagem");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		passagem.setDataViagem(dataParaBanco);
		passagem.setDestino(destino);
		passagem.setUsuario(usuario);
		passagem.setPacotePromo(Integer.parseInt(request.getParameter("nPacotePromo")));
		pdao.save(passagem);

		response.sendRedirect("./passagem");
	}

}
