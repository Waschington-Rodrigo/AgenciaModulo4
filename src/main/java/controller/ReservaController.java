package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import agencia.DAO.HospedagemDAO;
import agencia.DAO.ReservaDAO;
import agencia.DAO.UsuarioDAO;
import agencia.model.Hospedagem;
import agencia.model.Reserva;
import agencia.model.Usuario;

@WebServlet(urlPatterns = { "/reserva", "/reserva-create", "/reserva-delete", "/reserva-update" })
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Reserva reserva = new Reserva();
	ReservaDAO rdao = new ReservaDAO();
	Hospedagem hospedagem = new Hospedagem();
	Usuario usuario = new Usuario();
	HospedagemDAO hdao = new HospedagemDAO();
	UsuarioDAO udao = new UsuarioDAO();

	SimpleDateFormat simpleData = new SimpleDateFormat("yyyy-MM-dd");
	Date dataParaBanco = new Date();

	public ReservaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/reserva":
			listaReserva(request, response);
			break;
		case "/reserva-delete":
			deleteReserva(request, response);
			break;

		case "/reserva-update":
			updateReserva(request, response);
			break;

		case "/reserva-create":
			createReserva(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/reserva-create":
			postCreateReserva(request, response);
			break;
		case "/reserva-update":
			postUpdateReserva(request, response);
			break;
		}
	}

	protected void listaReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Reserva> lista = rdao.getReservas();

		request.setAttribute("listaReservas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reservas/listareserva.jsp");
		rd.forward(request, response);

	}

	protected void createReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Hospedagem> lista = hdao.getHospedagens();

		request.setAttribute("listaHospedagens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reservas/formReserva.jsp");
		rd.forward(request, response);

	}

	protected void deleteReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		rdao.removedById(id);
		response.sendRedirect("./reserva");
	}

	protected void postCreateReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dataFormulario = request.getParameter("nDataReserva");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cpfUsuario = request.getParameter("nCpf");
		int idHospedagem = Integer.parseInt(request.getParameter("nIdHospedagem"));
		int qtdDias = Integer.parseInt(request.getParameter("nQtdDias"));

		usuario = udao.getUsuarioByCPF(cpfUsuario);
		hospedagem = hdao.getHospedagemById(idHospedagem);
		Double valorHospedagem = hospedagem.getValorDiaria();
		float valorTotal = (float) (valorHospedagem * qtdDias);

		reserva.setDataReserva(dataParaBanco);
		reserva.setHospedagem(hospedagem);
		reserva.setUsuario(usuario);
		reserva.setQtdDias(qtdDias);
		reserva.setPacotePromo(Integer.parseInt(request.getParameter("nPacotePromo")));
		reserva.setValorTotal(valorTotal);

		rdao.save(reserva);
		response.sendRedirect("./reserva");
	}

	protected void updateReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		reserva = rdao.getReservaById(id);
		List<Hospedagem> lista = hdao.getHospedagens();
		
		request.setAttribute("listaHospedagens", lista);
		request.setAttribute("reserva", reserva);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reservas/updateReserva.jsp");
		rd.forward(request, response);
	}

	protected void postUpdateReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dataFormulario = request.getParameter("nDataReserva");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String cpfUsuario = request.getParameter("nCpf");
		int idHospedagem = Integer.parseInt(request.getParameter("nIdHospedagem"));
		int qtdDias = Integer.parseInt(request.getParameter("nQtdDias"));

		usuario = udao.getUsuarioByCPF(cpfUsuario);
		hospedagem = hdao.getHospedagemById(idHospedagem);
		Double valorHospedagem = hospedagem.getValorDiaria();
		float valorTotal = (float) (valorHospedagem * qtdDias);
		
		reserva.setId(Integer.parseInt(request.getParameter("nId")));
		reserva.setDataReserva(dataParaBanco);
		reserva.setHospedagem(hospedagem);
		reserva.setUsuario(usuario);
		reserva.setQtdDias(qtdDias);
		reserva.setPacotePromo(Integer.parseInt(request.getParameter("nPacotePromo")));
		reserva.setValorTotal(valorTotal);

		rdao.update(reserva);
		response.sendRedirect("./reserva");
	}

}
