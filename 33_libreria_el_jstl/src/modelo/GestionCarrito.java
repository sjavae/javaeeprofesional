package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Carrito;

public class GestionCarrito {
	DataSource ds;
    public GestionCarrito(){
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }
    
    public List<Carrito> recuperarCarrito(){
        String sql="select * from libros" ;
        return carrito(sql);
     }
     
     public List<Carrito> recuperarCarrito(int isbn){
        String sql="select * from libros where idTema="+isbn ; 
        return carrito(sql);
     }
     private List<Carrito> carrito(String sql){
        List<Carrito> lista=new ArrayList<> ();
            
         try(Connection cn=ds.getConnection();) {                       
             //Paso 2: Envio SQL
            
             Statement st=cn.createStatement();
             ResultSet rs=st.executeQuery(sql);            
             while(rs.next()){
                 lista.add(new Carrito(rs.getInt("isbn"),
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
}
