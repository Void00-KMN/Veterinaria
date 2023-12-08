package dao;
import datos.Libreria;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Venta;
public class VentaDAO extends Libreria{
	public VentaDAO() {
		super("ventas");
	}
	public void registrar(Venta venta) {
		try {
			callableStatement=getConnection().prepareCall("CALL proc_insertar_ventas (?,?,?)");
			callableStatement.setInt(1, venta.getDniCliente());
			callableStatement.setInt(2, venta.getIdProducto());
			callableStatement.setInt(3, venta.getCantidad());
			callableStatement.execute();
			JOptionPane.showMessageDialog(null, "Venta registrada correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Venta> consultar() {
		List<Venta> ventas= new ArrayList<Venta>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM v_consultar_ventas");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Venta venta=new Venta();
				venta.setIdVenta(resultSet.getInt("id_venta"));
				venta.setFechaVenta(resultSet.getString("fecha_venta"));
				venta.setDniCliente(resultSet.getInt("dni"));
				venta.setNombre(resultSet.getString("nombres"));
				venta.setProducto(resultSet.getString("producto"));
				venta.setCantidad(resultSet.getInt("cantidad"));
				venta.setSubtotal(resultSet.getDouble("subtotal"));
				venta.setIgv(resultSet.getDouble("igv"));
				venta.setTotal(resultSet.getDouble("total"));
				venta.setPrecio(resultSet.getDouble("precio"));
				ventas.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}
}
