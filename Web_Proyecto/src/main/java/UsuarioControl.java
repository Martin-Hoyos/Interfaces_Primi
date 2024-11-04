
public class UsuarioControl {

	private int id;
	private String Nombre_completo, Email, contraseña;
	public String getNombre_completo() {
		return Nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		Nombre_completo = nombre_completo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	

}
