package lojaonline.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lojaonline.modelo.Usuario;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario u = Usuario.login(email, senha);
		
		boolean logado = (u.getEmail() == email);
		
		if(logado) {

            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(60*15);
            session.setAttribute("usuario", u);
            if(u.isAdmin()) {
            	response.sendRedirect("ExibirProduto.jsp");
            }else {
            	response.sendRedirect("ListaProdutos.jsp");	
            }
            

	    } else {
	        RequestDispatcher d = request.getRequestDispatcher("Login");
	        d.forward(request, response);
	    }
		
		
	}

}
