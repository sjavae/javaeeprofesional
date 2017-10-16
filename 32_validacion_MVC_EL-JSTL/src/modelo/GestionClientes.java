package modelo;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GestionClientes {
	
	DataSource ds;
	
	public GestionClientes() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean registrarCliente(String nombre, String pass, String email, int telefono ) {
		boolean regsitro=false;
		try (Connection cn=ds.getConnection()) {
			String sql="insert into clientes (usuario,password,email,telefono) "
					+ "values(?,?,?,?)";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setInt(4, telefono);
			ps.execute();
			regsitro=true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean estaRegistrado(String user, String pass) {
		//comprobar si la combinación user y pass están en la base de datos
		boolean resultado=false;
		try(Connection cn=ds.getConnection()){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			//si hay registro coincidente devuelve true
			if(rs.next()) {
				resultado=true;
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}
	
}
	
