package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Libro;
import modelo.GestionLibros;

/**
 * Servlet implementation class LibrosAction
 */
@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tema=Integer.parseInt(request.getParameter("tema"));
		GestionLibros glibros=new GestionLibros();	
		
		List<Libro> libros=(List<Libro>) glibros.RecuperarLibros(tema);
		
		//pasamos el atributo a libros.jsp para que pinte la tabla
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

}
