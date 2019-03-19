package lojaonline.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lojaonline.modelo.Produto;

/**
 * Servlet implementation class SalvarProduto
 */
@WebServlet("/SalvarProduto")
public class SalvarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvarProduto() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	resp.getWriter().append("hello").close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Double preco = Double.parseDouble(request.getParameter("preco").replace(",","."));
		int estoque = Integer.parseInt(request.getParameter("estoque"));
		
		Produto p = new Produto(nome, descricao, preco, estoque);
		
		p.save();
		
		response.sendRedirect("CadastroProduto.html");
	}

}
