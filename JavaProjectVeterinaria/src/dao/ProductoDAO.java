package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datos.Libreria;
import entidades.Producto;
public class ProductoDAO extends Libreria{
	public ProductoDAO() {
		super("productos");
	}
	public void registrar(Producto producto) {
		try {
			preparedStatement=getConnection().prepareStatement("INSERT INTO productos (producto,marca,precio,categoria)"
					+ "VALUES (?,?,?,?)");
			preparedStatement.setString(1, producto.getProducto());
			preparedStatement.setString(2, producto.getMarca());
			preparedStatement.setDouble(3, producto.getPrecio());
			preparedStatement.setString(4, producto.getCategoria());
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Producto> consultar() {
		List<Producto> productos=new ArrayList<Producto>();
		try {
			preparedStatement=getConnection().prepareStatement("SELECT * FROM productos");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Producto producto=new Producto();
				producto.setId_producto(resultSet.getInt("id_producto"));
				producto.setProducto(resultSet.getString("producto"));
				producto.setMarca(resultSet.getString("marca"));
				producto.setPrecio(resultSet.getDouble("precio"));
				producto.setCategoria(resultSet.getString("categoria"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productos;
	}
}