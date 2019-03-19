package lojaonline.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lojaonline.modelo.Produto;

@WebServlet("/SalvarProduto")
public class SalvarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SalvarProduto() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println(Produto.all());
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
