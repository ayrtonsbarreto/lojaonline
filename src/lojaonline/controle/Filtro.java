package lojaonline.controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*") //Filtrando todas as páginas
public class Filtro implements Filter {
    public Filtro() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession(); //capturando a sessao}
        
        if(session.getAttribute("usuario") != null || url.lastIndexOf("Login.html")>-1 || url.lastIndexOf("CadastroUsuario.html")>-1 || url.lastIndexOf("Login")>-1 || url.lastIndexOf("ListaProdutos.jsp")>-1 || url.lastIndexOf("VerCarrinho.jsp")>-1) {
            chain.doFilter(request, response);
        }else {
            ((HttpServletResponse) response).sendRedirect("Login.html");
        }
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    }

}