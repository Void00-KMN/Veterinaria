package dao;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import datos.Libreria;
import entidades.Mascota;
public class MascotaDAO extends Libreria{
	public MascotaDAO() {
		super("mascotas");
	}
	public void registrar(Mascota mascota){
		try {
			callableStatement=getConnection().prepareCall("CALL proc_insertar_mascotas (?,?,?,?,?)");
			callableStatement.setString(1, mascota.getNombre());
			callableStatement.setString(2, mascota.getEspecie());
			callableStatement.setString(3, mascota.getRaza());
			callableStatement.setInt(4, mascota.getEdad());
			callableStatement.setInt(5, mascota.getDniCliente());
			callableStatement.execute();
			JOptionPane.showMessageDialog(null, "Mascota registrada correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Mascota> consulta() {
		List<Mascota> mascotas=new ArrayList<Mascota>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM v_consultar_mascotas");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Mascota mascota=new Mascota();
				mascota.setIdMascota(resultSet.getInt(1));
				mascota.setEspecie(resultSet.getString(2));
				mascota.setNombre(resultSet.getString(3));
				mascota.setEdad(resultSet.getInt(4));
				mascota.setClienteNombre(resultSet.getString(5));
				mascota.setClienteDni(resultSet.getInt(7));
				mascotas.add(mascota);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
	}
}
