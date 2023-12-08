package dao;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import datos.Libreria;
import entidades.AdopMascota;
public class AdopMascotaDAO extends Libreria{
	public AdopMascotaDAO() {
		super("no_aplicable");
	}
	public void registrar(AdopMascota mascotaA) {
		try {
			preparedStatement=getConnection().prepareStatement("INSERT INTO mascotas_adopcion (nombre, especie, raza, edad) VALUES (?,?,?,?)");
			preparedStatement.setString(1, mascotaA.getNombre());
			preparedStatement.setString(2, mascotaA.getEspecie());
			preparedStatement.setString(3, mascotaA.getRaza());
			preparedStatement.setInt(4, mascotaA.getEdad());
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Mascota en adopción registrada correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<AdopMascota> consultar() {
		List<AdopMascota> mascotasA=new ArrayList<AdopMascota>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM mascotas_adopcion");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				AdopMascota mascotaA = new AdopMascota();
				mascotaA.setIdAdopMascota(resultSet.getInt(1));
				mascotaA.setNombre(resultSet.getString(2));
				mascotaA.setEspecie(resultSet.getString(3));
				mascotaA.setRaza(resultSet.getString(4));
				mascotaA.setEdad(resultSet.getInt(5));
				mascotasA.add(mascotaA);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}return mascotasA;
	}
}
