package lojaonline.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lojaonline.modelo.Carrinho;
import lojaonline.modelo.Produto;

@WebServlet("/CarrinhoServlet")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CarrinhoServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String command = request.getParameter("comando");
		int id = Integer.parseInt(request.getParameter("id"));
		
		String carrinhoTxt = Carrinho.getCartCookie(request);
		System.out.println(carrinhoTxt);
		
		if (carrinhoTxt != null && !carrinhoTxt.equals("")) {
			String s = Carrinho.updateCartString(carrinhoTxt, command, id);
			Cookie cart = new Cookie("cart", s);
			cart.setMaxAge(60*60*48);
			response.addCookie(cart);

		}else {
			Cookie cart = new Cookie("cart", id+"Q"+1+" ");
			cart.setMaxAge(60*60*48);
			response.addCookie(cart);
		}
		
		if(command.equals("remove")) {
			response.sendRedirect("VerCarrinho.jsp");
		}else {
			response.sendRedirect("ListaProdutos.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
