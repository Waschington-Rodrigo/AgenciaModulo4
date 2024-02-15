package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import agencia.DAO.UsuarioDAO;
import agencia.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-delete", "/usuario-update" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioDAO udao = new UsuarioDAO();
	Usuario usuario = new Usuario();
	SimpleDateFormat simpleData = new SimpleDateFormat("yyyy-MM-dd");
	Date dataParaBanco = new Date();

	public UsuarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/usuario":
			listaUsuario(request, response);
			break;
		case "/usuario-delete":
			deleteUsuario(request, response);
			break;

		case "/usuario-update":
			updateUsuario(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/usuario-create":
			createUsuario(request, response);
			break;
		case "/usuario-update":
			postUpdateUsuario(request, response);
			break;
		}
	}

	protected void listaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Usuario> lista = udao.getUsuarios();

		request.setAttribute("listaUsuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/listausuario.jsp");
		rd.forward(request, response);

	}

	protected void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		udao.removedById(id);
		response.sendRedirect("usuario");
	}

	protected void createUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dataFormulario = request.getParameter("nDataNascimento");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		usuario.setDataNascimento(dataParaBanco);
		usuario.setNome(request.getParameter("nNome"));
		usuario.setCpf(request.getParameter("nCPF"));
		usuario.setEmail(request.getParameter("nEmail"));
		usuario.setTelefone(request.getParameter("nTelefone"));
		usuario.setEndereco(request.getParameter("nEndereco"));
		usuario.setEstado(request.getParameter("nEstado"));
		usuario.setCidade(request.getParameter("nCidade"));
		udao.save(usuario);
		response.sendRedirect("./usuario");
	}

	protected void updateUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		usuario = udao.getUsuarioById(id);

		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("./views/usuarios/updateUsuario.jsp");
		rd.forward(request, response);
	}

	protected void postUpdateUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dataFormulario = request.getParameter("nDataNascimento");
		try {
			dataParaBanco = simpleData.parse(dataFormulario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setId(Integer.parseInt(request.getParameter("nId")));
		usuario.setDataNascimento(dataParaBanco);
		usuario.setNome(request.getParameter("nNome"));
		usuario.setCpf(request.getParameter("nCPF"));
		usuario.setEmail(request.getParameter("nEmail"));
		usuario.setTelefone(request.getParameter("nTelefone"));
		usuario.setEndereco(request.getParameter("nEndereco"));
		usuario.setEstado(request.getParameter("nEstado"));
		usuario.setCidade(request.getParameter("nCidade"));
		udao.update(usuario);
		response.sendRedirect("./usuario");
	}
}
