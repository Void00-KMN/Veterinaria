package dao;
import datos.Libreria;
import entidades.Adopcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class AdopcionDAO extends Libreria{
	public AdopcionDAO() {
		super("adopciones");
	}
	public void registrar(Adopcion adopcion) {
		try {
			callableStatement=getConnection().prepareCall("CALL proc_insertar_adopciones(?,?)");
			callableStatement.setInt(1, adopcion.getDniCliente());
			callableStatement.setInt(2, adopcion.getIdMascota());
			callableStatement.executeQuery();
			JOptionPane.showMessageDialog(null, "Adopcion registrada correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Adopcion> consultar() {
		List<Adopcion> adopciones=new ArrayList<Adopcion>();
		try {
			preparedStatement=getConnection().prepareCall("SELECT * FROM v_consultar_adopciones");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Adopcion adopcion=new Adopcion();
				adopcion.setIdAdopcion(resultSet.getInt("id_adopcion"));
				adopcion.setFechaAdopcion(resultSet.getString("fecha_adopcion"));
				adopcion.setNombreMascota(resultSet.getString(2));
				adopcion.setEspecie(resultSet.getString("especie"));
				adopcion.setClienteNombre(resultSet.getString(5));
				adopcion.setDniCliente(resultSet.getInt("dni"));
				adopciones.add(adopcion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return adopciones;
	}
}
