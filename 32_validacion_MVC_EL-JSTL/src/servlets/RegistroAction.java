package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;

/**
 * Servlet implementation class RegistroAction
 */
@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String tlfn=request.getParameter("telefono");
		GestionClientes gclientes=new GestionClientes();
		
		gclientes.registrarCliente(user, pass, email, Integer.parseInt(tlfn));
		
		//Redirigir y transferir el control
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
