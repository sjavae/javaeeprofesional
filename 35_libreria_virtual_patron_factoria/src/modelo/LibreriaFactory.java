package modelo;

//esta clase proporciona implementación de las interfaces de negocio
public class LibreriaFactory {
	public static GestionClientes getGestionClientes() {
		return new GestionClientesImpl();
	}
	public static GestionTemas getGestionTemas() {
		return new GestionTemasImpl();
	}
	public static GestionLibros getGestionLibos() {
		return new GestionLibrosImpl();
	}
	public static GestionVentas getGestionVentas() {
		return new GestionVentasImpl();
	}
}
