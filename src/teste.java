

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CabecalhoHttp
 */
@WebServlet("/teste")
public class teste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			
			Enumeration e = req.getHeaderNames();
			
			out.println("<H3>Cabeçalhos vindos do cliente<BR></H3>");
			 
		    out.println("<table border=2 bordercolor=blue>");
		 
		    out.println("<tr><th>Nome do Cabeçalho</th><th>Valor do Cabeçalho</th></tr>");
			
			while(e.hasMoreElements()) { //testa se a enumeração tem elementos
				String name = (String)e.nextElement();
				String value = req.getHeader(name);
				out.println("<tr><th>"+name + "</th><th>" + value + "</th></tr>");
			}
		out.println("</table>");
		out.close();
		}
}
