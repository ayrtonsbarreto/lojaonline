package lojaonline.controle;

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
		//System.out.println("olá");
		resp.getWriter().append("Served at: ").append(req.getContextPath()).close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='/lojaonline/CadastroUsuario.html'>Realizar Cadastro</a> </br>");
		out.println("<a href='/lojaonline/ListaProdutos.jsp'>Listar os produtos</a> </br>");
		out.println("<a href='/lojaonline/Deslogar'>Desconectar</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
