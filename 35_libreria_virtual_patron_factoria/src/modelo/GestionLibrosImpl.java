/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Libro;

/**
 *
 * @author Profesortarde
 */
 class GestionLibrosImpl implements GestionLibros {
	 DataSource ds;
	    public GestionLibrosImpl(){
	    	try {
				Context ctx=new InitialContext();
				ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
			} catch (NamingException e) {			
				e.printStackTrace();
			}
	        
	    }
    
    /* (non-Javadoc)
	 * @see modelo.GestionLibros#recuperarLibros()
	 */
    @Override
	public List<Libro> recuperarLibros(){
       String sql="select * from libros" ;
       return libros(sql);
    }
    
    /* (non-Javadoc)
	 * @see modelo.GestionLibros#recuperarLibros(int)
	 */
    @Override
	public List<Libro> recuperarLibros(int idTema){
       String sql="select * from libros where idTema="+idTema ; 
       return libros(sql);
    }
    private List<Libro> libros(String sql){
       List<Libro> lista=new ArrayList<> ();
           
        try(Connection cn=ds.getConnection();) {                       
            //Paso 2: Envio SQL
           
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Libro(rs.getInt("isbn"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getDouble("precio"),
                        rs.getInt("paginas"),
                        rs.getInt("idTema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return lista; 
    }
    /* (non-Javadoc)
	 * @see modelo.GestionLibros#recuperarLibroPorIsbn(int)
	 */
    @Override
	public Libro recuperarLibroPorIsbn(int isbn) {
		Libro lib=null;
		try(Connection cn=ds.getConnection()){
			
			String sql="select * from libros where isbn=?";
			PreparedStatement ps=cn.prepareStatement(sql);
			ps.setInt(1, isbn);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				lib=new Libro(isbn,
								rs.getString("titulo"),
								rs.getString("autor"),
								rs.getDouble("precio"),
								rs.getInt("paginas"),
								rs.getInt("idTema"));
			}
			
		}
		catch (SQLException ex) {
            ex.printStackTrace();
        } 
		return lib;
	}
}
