package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Desconexion
 */
@WebServlet("/DesconectarAction")
public class DesconectarAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hacemos la desconexion recogiendo la sesion..
		HttpSession s=request.getSession();
		// y la invalidamos (Cierre de sesi�n)
		s.invalidate();
		//volvemos a la p�gina de inicio
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
