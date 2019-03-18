package lojaonline.controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import lojaonline.modelo.Usuario;

public class CadastroUsuario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CadastroUsuario() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		// array list com pessoas existentes 
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) getServletContext().getAttribute("usuarios");
		
		Usuario u = new Usuario(nome,email,senha);
		
		usuarios.add(u);
		
		getServletContext().setAttribute("usuarios", usuarios);
		
		//redirecionado para Página do cliente após o cadastro
		RequestDispatcher red = req.getRequestDispatcher("/ClientePage");
	}
}
