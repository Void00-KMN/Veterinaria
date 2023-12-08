package entidades;
public class Adopcion {
	private int dniCliente;
	private int idMascota;
	private int idAdopcion;
	private String fechaAdopcion;
	private String nombreMascota;
	private String especie;
	private String clienteNombre;
	public int getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(int dniCliente) {
		this.dniCliente = dniCliente;
	}

	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public int getIdAdopcion() {
		return idAdopcion;
	}
	public void setIdAdopcion(int idAdopcion) {
		this.idAdopcion = idAdopcion;
	}
	public String getFechaAdopcion() {
		return fechaAdopcion;
	}
	public void setFechaAdopcion(String fechaAdopcion) {
		this.fechaAdopcion = fechaAdopcion;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
}
