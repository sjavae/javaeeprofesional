package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Carrito;
import javabeans.Libro;

public class GestionCarrito {
	DataSource ds;
	List<Carrito> carrito=new ArrayList<> ();  
	
    public GestionCarrito(){
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }
    
    public List<Carrito> recuperarCarrito(){
    	 List<Carrito> lista=new ArrayList<> ();          
         try(Connection cn=ds.getConnection();) {                       
             //Paso 2: Envio SQL
             String sql="select * from carritos"; 
             Statement st=cn.createStatement();
             ResultSet rs=st.executeQuery(sql);            
             while(rs.next()){
                 lista.add(new Carrito(rs.getInt("isbn"),
                         rs.getString("titulo"),
                         rs.getString("autor"),
                         rs.getDouble("precio"),
                         rs.getInt("idTema")));
             } 
         }catch (SQLException e){
             	e.printStackTrace();
          }
          return lista;
        
     }
     
     public List<Carrito> registrarCarrito(int isbn){
    	 String sql="select * from libros where isbn="+isbn ;
         return carrito(sql);
     }
     
     private List<Carrito> carrito(String sql){
        List<Carrito> lista=new ArrayList<> ();          
         try(Connection cn=ds.getConnection();) {                       
             //Paso 2: Envio SQL
            
             Statement st=cn.createStatement();
             ResultSet rs=st.executeQuery(sql);            
             while(rs.next()){
                 carrito.add(new Carrito(rs.getInt("isbn"),
                         rs.getString("titulo"),
                         rs.getString("autor"),
                         rs.getDouble("precio"),
                         rs.getInt("idTema")));
                 agregarCarrito(rs.getInt("isbn"),
                		 rs.getString("titulo"),
                         rs.getString("autor"),
                         rs.getDouble("precio"),
                         rs.getInt("idTema"));
             }
         }  catch (SQLException ex) {
             ex.printStackTrace();
         }   
         return carrito; 
     }
     public void agregarCarrito(int isbn, String titulo, String autor, Double precio, int idTema) {        
         try(Connection cn=ds.getConnection();) {                       
             //Paso 2: Envio SQL
        	 String sql="Insert into carritos (isbn,titulo,autor,precio,idTema) values(?,?,?,?,?)";
             //creamos consulta preparada:
             PreparedStatement ps=cn.prepareStatement(sql);
                //Sustituimos parametros por valores
                ps.setInt(1, isbn);
                ps.setString(2, titulo);
                ps.setString(3, autor);
                ps.setDouble(4, precio);
                ps.setInt(5, idTema);
                ps.execute();
             } catch (SQLException e) {
				e.printStackTrace();
			}
     }
     
     public void comprarTodo(int idCliente, int idLibro, Date fecha) {
    	 try(Connection cn=ds.getConnection();) {                       
             //Paso 2: Envio SQL
        	 String sql="Insert into ventas (idCliente,idLibro,fecha) values(?,?,?)";
             //creamos consulta preparada:
             PreparedStatement ps=cn.prepareStatement(sql);
                //Sustituimos parametros por valores
                ps.setInt(1, idCliente);
                ps.setInt(2, idLibro);
                ps.setDate(3, fecha);
                ps.execute();
             } catch (SQLException e) {
				e.printStackTrace();
			}
     }

	public void eliminarCarrito(int isbn) {
		// TODO Auto-generated method stub
		try(Connection cn=ds.getConnection();) {                       
            //Paso 2: Envio SQL
       	 String sql="delete from carritos where isbn=?";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setInt(1, isbn);
               ps.execute();
            } catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public void eliminarTodoCarrito(String user) {
		try(Connection cn=ds.getConnection();) {                       
            //Paso 2: Envio SQL
       	 String sql="delete from carritos where idCliente=?";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, user);
               ps.execute();
            } catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
