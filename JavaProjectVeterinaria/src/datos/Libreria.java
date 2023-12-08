package datos;
import java.sql.*;
public class Libreria {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user="system";
	private String password="oracle123";
	public Connection connection;
	public CallableStatement callableStatement;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	public String table;
	public Connection getConnection() {
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e1) {
			System.out.println("Error en el driver "+e1);
		}catch(SQLException e2) {
			System.out.println("Error en la conexión "+e2);
		}return connection;
	}
	public Libreria(String table) {
		this.table=table;
	}
	
	//Metodos de eliminación y busqueda
	//Pendiente----------
	public void eliminar(int codigo) {
		try {
			preparedStatement=getConnection().prepareStatement("DELETE FROM "+table+" WHERE id_"+(table.substring(0, table.length()-1))+" = "+codigo);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void buscar(int codigo) {
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM "+table+" WHERE id_"+(table.substring(0, table.length()-1))+" = "+codigo);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
