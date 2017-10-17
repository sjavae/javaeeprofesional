package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javabeans.Cliente;

class GestionClientesImpl implements GestionClientes {
	DataSource ds;
    public GestionClientesImpl(){
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }
	
	/* (non-Javadoc)
	 * @see modelo.GestionClientes#estaRegistrado(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean estaRegistrado(String user, String pass) {
		boolean res=false;
		try(Connection con=ds.getConnection()){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see modelo.GestionClientes#registrar(javabeans.Cliente)
	 */
	@Override
	public void registrar(Cliente c) {
		try(Connection cn=ds.getConnection()) {                       
	           
            String sql="insert into clientes (usuario,password,email,telefono) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, c.getUsuario());
               ps.setString(2, c.getPassword());
               ps.setString(3, c.getEmail());
               ps.setInt(4, c.getTelefono());
               //ejecutamos
             ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }  
		
	}
	/* (non-Javadoc)
	 * @see modelo.GestionClientes#obtenerCliente(java.lang.String, java.lang.String)
	 */
	@Override
	public Cliente obtenerCliente(String usuario, String password) {
		Cliente c=null;
		try(Connection cn=ds.getConnection();) {                       
	           
            String sql="Select * from clientes where ";
            sql+="usuario=? and password=?";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, usuario);
               ps.setString(2, password);
               
               //ejecutamos
              ResultSet rs= ps.executeQuery();
              if(rs.next()){
            	   c=new Cliente(rs.getInt("idCliente"), 
            			  rs.getString("usuario"), 
            			  rs.getString("password"),
            			  rs.getString("email"),
            			  rs.getInt("telefono"));
              }
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } 
		return c;
	}

}
