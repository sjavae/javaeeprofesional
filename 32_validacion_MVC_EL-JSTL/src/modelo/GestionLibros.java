package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Libro;
import javabeans.Tema;

public class GestionLibros {
	DataSource ds;
	public GestionLibros() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Libro> RecuperarLibros(int idTema){
		ArrayList<Libro> libros=new ArrayList<>();
		try(Connection cn=ds.getConnection()) {
			String sql="select * from libros";
			if (idTema!=0) {
				sql="select * from libros where idTema='"+idTema+"'";
			}
			PreparedStatement ps=cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			//mientras haya registros..
			while(rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getInt("precio"),
						rs.getInt("paginas"),
						rs.getInt("idTema")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
				
		return libros;
		
	}
}
