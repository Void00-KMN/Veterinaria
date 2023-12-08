package dao;
import entidades.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import datos.Libreria;
public class ClienteDAO extends Libreria{
	public ClienteDAO() {
		super("clientes");
	}

	public void registrar(Cliente cliente) {
		try {
			preparedStatement=getConnection().prepareStatement("INSERT INTO clientes (nombres,apellidos,telefono,direccion,dni)"
					+ "VALUES (?,?,?,?,?)");
			preparedStatement.setString(1, cliente.getNombres());
			preparedStatement.setString(2, cliente.getApellidos());
			preparedStatement.setInt(3, cliente.getTelefono());
			preparedStatement.setString(4, cliente.getDireccion());
			preparedStatement.setInt(5, cliente.getDni());
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
		} catch (SQLException e) {
			System.out.println("Error en el proceso de registro "+e);
		}
	}
	
	public List<Cliente> consultar() {
		List<Cliente> clientes=new ArrayList<Cliente>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM clientes");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Cliente cliente=new Cliente();
				cliente.setId_cliente(resultSet.getInt(1));
				cliente.setNombres(resultSet.getString(2));
				cliente.setApellidos(resultSet.getString(3));
				cliente.setTelefono(resultSet.getInt(4));
				cliente.setDireccion(resultSet.getString(5));
				cliente.setDni(resultSet.getInt(6));
				clientes.add(cliente);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
}
