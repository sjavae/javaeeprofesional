package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=request.getParameter("op");
		String url="";
		switch(op) {
			case "doLogin":
				url="LoginAction";
				break;
			case "doRegistro":
				url="RegistroAction";
				break;
			case "doLibros":
				url="LibrosAction";
				break;
			case "doDesconectar":
				url="DesconectarAction";
				break;
			case "doEliminar":
				url="EliminarAction";
				break;
			case "toRegistro":
				url="registroCliente.jsp";
				break;
			case "toInicio":
				url="index.jsp";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
