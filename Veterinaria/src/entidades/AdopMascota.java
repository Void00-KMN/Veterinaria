package entidades;
public class AdopMascota {
	private int idAdopMascota;
	private String nombre;
	private String especie;
	private String raza;
	private int edad;
	public int getIdAdopMascota() {
		return idAdopMascota;
	}
	public void setIdAdopMascota(int idAdopMascota) {
		this.idAdopMascota = idAdopMascota;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
