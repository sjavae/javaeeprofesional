package javabeans;

public class Libro {
	private int isbn;
	private String titulo;
	private String 	autor;
	private int precio;
	private int paginas;
	private int idTema;
	
	public Libro(int isbn, String t�tulo, String autor, int precio, int p�ginas, int idTema) {
		this.isbn = isbn;
		this.titulo = t�tulo;
		this.autor = autor;
		this.precio= precio;
		this.paginas = p�ginas;
		this.idTema = idTema;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		titulo = titulo;
	}

	public String getAutor() {
		return titulo;
	}

	public void setAutor(String autor) {
		titulo = autor;
	}

	public int getPrecio() {
		return idTema;
	}

	public void setPrecio(int precio) {
		idTema = precio;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setP�ginas(int paginas) {
		paginas = paginas;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", T�tulo=" + titulo + ", Autor=" + titulo + ", Precio=" + idTema + ", P�ginas="
				+ paginas + ", idTema=" + idTema + "]";
	}
	
	
	
}
