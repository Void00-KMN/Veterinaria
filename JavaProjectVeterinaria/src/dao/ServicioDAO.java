package dao;
import entidades.Servicio;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import datos.Libreria;
public class ServicioDAO extends Libreria {
	public ServicioDAO() {
		super("servicios");
	}
	public void registrar(Servicio servicio) {
		try {
			callableStatement=getConnection().prepareCall("CALL proc_insertar_servicios (?,?,?,?)");
			callableStatement.setString(1, servicio.getTipoServicio());
			callableStatement.setInt(2, servicio.getDniCliente());
			callableStatement.setInt(3, servicio.getIdMascota());
			callableStatement.setInt(4, servicio.getIdVeterinario());
			callableStatement.executeQuery();
			JOptionPane.showMessageDialog(null, "Servicio registrado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Servicio> consultar() {
		List<Servicio> servicios=new ArrayList<Servicio>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM v_consultar_servicios");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Servicio servicio=new Servicio();
				servicio.setIdServicio(resultSet.getInt(1));
				servicio.setFechaServicio(resultSet.getString(2));
				servicio.setTipoServicio(resultSet.getString(3));
				servicio.setNombreMascota(resultSet.getString(4));
				servicio.setClienteNombre(resultSet.getString(5));
				servicio.setDniCliente(resultSet.getInt(7));
				servicio.setNombreVeterinario(resultSet.getString(8));
				servicios.add(servicio);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return servicios;
	}
}
