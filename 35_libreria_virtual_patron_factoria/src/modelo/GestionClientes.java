package modelo;

import javabeans.Cliente;

public interface GestionClientes {

	boolean estaRegistrado(String user, String pass);

	void registrar(Cliente c);

	Cliente obtenerCliente(String usuario, String password);

}