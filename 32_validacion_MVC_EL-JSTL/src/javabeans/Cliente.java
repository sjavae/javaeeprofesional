package javabeans;

public class Cliente {
	private int id;
	private String nombre;
	private String password;
	private String email;
	private int telefono;
	public Cliente(String nombre, String password, String email, int telefono) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Cliente(int id, String nombre, String password, String email, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
