package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestionClientes;
import modelo.GestionTemas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		GestionClientes gestion=new GestionClientes();
		
		if(gestion.estaRegistrado(request.getParameter("user"),request.getParameter("pwd"))){
			
            //request.setAttribute("temas", gtemas.obtenerTemas());
            url="TemasAction";
            if(request.getParameter("recordar")!=null){
                  crearCookie(response, request.getParameter("user"));
            }
            else{
                  crearCookie(response, "");
            }

		}
		else{
			
			url="error.jsp";
		}
       
        request.getRequestDispatcher(url).forward(request, response);
	}
	private void crearCookie(HttpServletResponse response, String valor){
        //crear objeto Cookie
        Cookie ck=new Cookie("user",valor);
        //periodo de vida
        ck.setMaxAge(100000);
        //Añade cookie a la cabecera de la respuesta
        response.addCookie(ck);
    }

}
