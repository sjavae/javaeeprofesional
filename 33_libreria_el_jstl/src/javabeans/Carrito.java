package javabeans;

public class Carrito {
	    private int isbn;
	    private String titulo;
	    private String autor;
	    private double precio;
	    private int idTema;
	    
		public Carrito(int isbn, String titulo, String autor, double precio, int idTema) {
			this.isbn = isbn;
			this.titulo = titulo;
			this.autor = autor;
			this.precio = precio;
			this.idTema=idTema;
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
			this.titulo = titulo;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}


		public int getIdTema() {
			return idTema;
		}


		public void setIdTema(int idTema) {
			this.idTema = idTema;
		}

		
}
