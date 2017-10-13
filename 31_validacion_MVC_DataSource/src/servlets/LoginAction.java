package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GestionClientes;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		GestionClientes gclientes=new GestionClientes();		
		
		if(gclientes.estaRegistrado(user, pass)) {
			String valorCookie="";
			if(request.getParameter("recordar")!=null) {
				valorCookie=request.getParameter("user");
			}
			guardarCookie(valorCookie,response);
			
			HttpSession s=request.getSession();
			s.setAttribute("usuario", request.getParameter("user"));
			RequestDispatcher rd=request.getRequestDispatcher("temas.jsp");
			//transferir el control
			rd.forward(request, response);
		} else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}
	private void guardarCookie(String valor, HttpServletResponse resp) {
		Cookie ck=new Cookie("usrname", valor);
		ck.setMaxAge(200000);
		resp.addCookie(ck);
	}

}
