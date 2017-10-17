package modelo;

import java.util.List;

import javabeans.Libro;

public interface GestionVentas {

	void registrarVenta(List<Libro> libros, int idCliente);

}