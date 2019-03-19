package lojaonline.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LojistaPage")
public class LojistaPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LojistaPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<a href='/lojaonline/CadastroProduto.html'>Cadastrar Produto</a> </br>");
		//out.println("<a href='/lojaonline/ExibeProdutos'>Listar os produtos</a> </br>");
		out.println("<a href='/lojaonline/Deslogar'>Desconectar</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
