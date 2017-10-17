package modelo;

import java.util.List;

import javabeans.Libro;

public interface GestionLibros {

	List<Libro> recuperarLibros();

	List<Libro> recuperarLibros(int idTema);

	Libro recuperarLibroPorIsbn(int isbn);

}