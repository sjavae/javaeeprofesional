package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Carrito;
import modelo.GestionCarrito;

/**
 * Servlet implementation class ComprasAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		GestionCarrito gcarrito=new GestionCarrito();
		List<Carrito> carritos;
		if(isbn==0) {
			carritos=gcarrito.recuperarCarrito();
		}else {
			carritos=gcarrito.recuperarCarrito(isbn);
		}
		request.setAttribute("carritos", carritos);
		request.getRequestDispatcher("libros_copia.jsp").forward(request, response);
	}

}
