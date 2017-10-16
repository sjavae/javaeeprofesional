package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Carrito;
import javabeans.Libro;
import modelo.GestionCarrito;
import modelo.GestionLibros;

/**
 * Servlet implementation class EliminarAction
 */
@WebServlet("/EliminarAction")
public class EliminarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idTema=Integer.parseInt(request.getParameter("tema"));
		GestionLibros glibros=new GestionLibros();
		List<Libro> libros;
		if(idTema==0){
			libros=glibros.recuperarLibros();
		}
		else{
			libros=glibros.recuperarLibros(idTema);
		}
		
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		GestionCarrito gcarrito=new GestionCarrito();
		gcarrito.eliminarCarrito(isbn);
		List<Carrito> carritos=gcarrito.recuperarCarrito();
		
		request.setAttribute("carritos", carritos);
		request.setAttribute("libros", libros);
		request.setAttribute("tema", idTema);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
