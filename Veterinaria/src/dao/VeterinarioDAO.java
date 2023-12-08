package dao;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import datos.Libreria;
import entidades.Veterinario;
public class VeterinarioDAO extends Libreria{
	public VeterinarioDAO() {
		super("veterinarios");
	}
	public void registrar(Veterinario empleado) {
		try {
			preparedStatement=getConnection().prepareStatement("INSERT INTO veterinarios (nombres, apellidos, telefono, direccion, dni, sueldo, cargo) VALUES (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, empleado.getNombre());
			preparedStatement.setString(2, empleado.getApellido());
			preparedStatement.setInt(3, empleado.getTelefono());
			preparedStatement.setString(4, empleado.getDireccion());
			preparedStatement.setInt(5, empleado.getDni());
			preparedStatement.setDouble(6, empleado.getSueldo());
			preparedStatement.setString(7, empleado.getCargo());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Veterinario> consultar(){
		List<Veterinario> empleados=new ArrayList<Veterinario>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM veterinarios");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Veterinario empleado=new Veterinario();
				empleado.setIdVet(resultSet.getInt(1));
				empleado.setNombre(resultSet.getString(2));
				empleado.setApellido(resultSet.getString(3));
				empleado.setTelefono(resultSet.getInt(4));
				empleado.setDireccion(resultSet.getString(5));
				empleado.setDni(resultSet.getInt(6));
				empleado.setSueldo(resultSet.getDouble(7));
				empleado.setCargo(resultSet.getString(8));
				empleados.add(empleado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return empleados;
	}
}
