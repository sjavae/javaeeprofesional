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

import javabeans.Tema;

public class GestionTemas {
	DataSource ds;
	public GestionTemas() {
		try {
			Context ctx=new InitialContext();
			ds=(DataSource) ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tema> RecuperarTemas(){
		ArrayList<Tema> temas=new ArrayList<>();
		try(Connection cn=ds.getConnection()) {
			String sql="select * from temas";
			PreparedStatement ps=cn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			//mientras haya registros..
			while(rs.next()) {
				temas.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
				
		return temas;
		
	}
}
