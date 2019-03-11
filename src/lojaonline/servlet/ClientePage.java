package lojaonline.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClientePage")
public class ClientePage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientePage() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='/lojaonline/cadastroUsuario.html'> Cadastro </a></br>");
		out.println("</body>");
		out.println("</html>");
	}
}
