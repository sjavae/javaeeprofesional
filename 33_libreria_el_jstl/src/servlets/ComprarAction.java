package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javabeans.Carrito;
import javabeans.Libro;
import modelo.GestionCarrito;
import modelo.GestionClientes;
import modelo.GestionLibros;

/**
 * Servlet implementation class ComprasAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("tema"));
		GestionLibros glibros=new GestionLibros();
		List<Libro> libros;
		if(idTema==0){
			libros=glibros.recuperarLibros();
		}
		else{
			libros=glibros.recuperarLibros(idTema);
		}
		
		GestionClientes gcliente=new GestionClientes();
		int idCliente=gcliente.idCliente(request.getParameter("cliente"));
		
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		GestionCarrito gcarrito=new GestionCarrito();
		gcarrito.registrarCarrito(isbn);
		List<Carrito> carritos=gcarrito.recuperarCarrito();
		
		request.setAttribute("cliente", idCliente);
		request.setAttribute("libros", libros);
		request.setAttribute("tema", idTema);
		request.setAttribute("carritos", carritos);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
