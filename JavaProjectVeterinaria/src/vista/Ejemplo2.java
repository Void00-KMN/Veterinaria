package vista;

import dao.AdopMascotaDAO;
import entidades.Venta;
import entidades.Veterinario;
import entidades.Producto;
import entidades.Servicio;
import entidades.AdopMascota;
import entidades.Adopcion;
import entidades.Cliente;
import entidades.Mascota;
import dao.VentaDAO;
import dao.VeterinarioDAO;
import dao.ProductoDAO;
import dao.ServicioDAO;
import dao.AdopcionDAO;
import dao.ClienteDAO;
import dao.MascotaDAO;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Ejemplo2 extends JFrame {
	
	ClienteDAO clienteDAO = new ClienteDAO();
	ProductoDAO productoDAO = new ProductoDAO();
	VentaDAO ventasDAO = new VentaDAO();
	AdopcionDAO adopcionDAO = new AdopcionDAO();
	AdopMascotaDAO adopMascotasDAO = new AdopMascotaDAO();
	VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
	ServicioDAO servicioDAO = new ServicioDAO();
	MascotaDAO mascotaDAO = new MascotaDAO();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtClienteNombre;
	private JTextField txtClienteApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtDireccion;
	private JTextField txtDniVenta;
	private JTextField txtCodigoProductoVenta;
	private JTextField txtCantidadVenta;
	private JTextField txtProductoNombre;
	private JTextField txtProductoMarca;
	private JTextField txtProductoPrecio;
	private JTextField txtProductoCategoria;
	private JTextField txtMascotaNombre;
	private JTextField txtMascotaRaza;
	private JTextField txtMascotaEspecie;
	private JTextField txtMascotaEdad;
	private JTextField txtServiciosTipo;
	private JTextField txtServiciosCodigoV;
	private JTextField txtAdopMascotasNombre;
	private JTextField txtAdopMascotasRaza;
	private JTextField txtAdopMascotasEspecie;
	private JTextField txtAdopMascotasEdad;
	private JTextField txtAdopcionDni;
	private JTextField txtAdopcionCodigoM;
	private JTextField txtServiciosCodigoM;
	private JTextField txtServiciosDni;
	private JTextField txtVeterinariosNombres;
	private JTextField txtVeterinariosApellidos;
	private JTextField txtVeterinariosTelefono;
	private JTextField txtVeterinariosDni;
	private JTextField txtVeterinariosDireccion;
	private JTextField txtVeterinariosSueldo;
	private JTextField txtVeterinariosCargo;
	private JTextField txtMascotaDni;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 frame = new Ejemplo2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 861, 635);
		contentPane.add(tabbedPane);
		
		JPanel Clientes = new JPanel();
		tabbedPane.addTab("Clientes", null, Clientes, null);
		Clientes.setLayout(null);
		
		JTabbedPane tabbedPane_c = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_c.setBounds(10, 11, 836, 574);
		Clientes.add(tabbedPane_c);
		
		JPanel registroCliente = new JPanel();
		tabbedPane_c.addTab("Registro", null, registroCliente, null);
		registroCliente.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(197, 148, 58, 14);
		registroCliente.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(433, 148, 63, 14);
		registroCliente.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(197, 198, 58, 14);
		registroCliente.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(433, 198, 63, 14);
		registroCliente.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		lblNewLabel_4.setBounds(197, 248, 89, 14);
		registroCliente.add(lblNewLabel_4);
		
		txtClienteNombre = new JTextField();
		txtClienteNombre.setBounds(303, 145, 113, 20);
		registroCliente.add(txtClienteNombre);
		txtClienteNombre.setColumns(10);
		
		txtClienteApellidos = new JTextField();
		txtClienteApellidos.setColumns(10);
		txtClienteApellidos.setBounds(506, 145, 120, 20);
		registroCliente.add(txtClienteApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(303, 195, 113, 20);
		registroCliente.add(txtTelefono);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(303, 245, 113, 20);
		registroCliente.add(txtDni);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(506, 195, 120, 20);
		registroCliente.add(txtDireccion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombres=txtClienteNombre.getText();
				String apellidos=txtClienteApellidos.getText();
				int telefono=Integer.parseInt(txtTelefono.getText());
				String direccion=txtDireccion.getText();
				int dni=Integer.parseInt(txtDni.getText());
				Cliente c=new Cliente();
				c.setNombres(nombres);
				c.setApellidos(apellidos);
				c.setTelefono(telefono);
				c.setDireccion(direccion);
				c.setDni(dni);
				clienteDAO.registrar(c);
			}
		});
		btnRegistrar.setBounds(504, 325, 89, 23);
		registroCliente.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(390, 325, 89, 23);
		registroCliente.add(btnCancelar);
		
		JPanel consultaCliente = new JPanel();
		tabbedPane_c.addTab("Consulta", null, consultaCliente, null);
		consultaCliente.setLayout(null);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setBounds(10, 67, 811, 434);
		consultaCliente.add(txtArea);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtArea.setText("CODIGO\tNOMBRES\tAPELLIDOS\tTELEFONO\tDIRECCION\tDNI");
				List<Cliente> clientes= clienteDAO.consultar();
				for(Cliente c : clientes) {
					txtArea.append("\n"+c.getId_cliente()+
								   "\t"+c.getNombres()+
							       "\t"+c.getApellidos()+
							       "\t"+c.getTelefono()+
							       "\t"+c.getDireccion()+
							       "\t"+c.getDni());
				}
			}
		});
		btnMostrar.setBounds(360, 512, 89, 23);
		consultaCliente.add(btnMostrar);
		
		JPanel mascotas = new JPanel();
		mascotas.setLayout(null);
		tabbedPane.addTab("Mascotas", null, mascotas, null);
		
		JTabbedPane tabbedPane_m = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_m.setBounds(10, 11, 836, 574);
		mascotas.add(tabbedPane_m);
		
		JPanel registroMascota = new JPanel();
		registroMascota.setLayout(null);
		tabbedPane_m.addTab("Registro", null, registroMascota, null);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("DNI Cliente");
		lblNewLabel_2_1_1_2.setBounds(197, 254, 97, 14);
		registroMascota.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Edad");
		lblNewLabel_4_1_1_1.setBounds(413, 198, 46, 14);
		registroMascota.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nombre");
		lblNewLabel_5_1.setBounds(197, 148, 89, 14);
		registroMascota.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Raza");
		lblNewLabel_2_1_1.setBounds(197, 198, 79, 14);
		registroMascota.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Especie");
		lblNewLabel_4_1_1.setBounds(413, 148, 46, 14);
		registroMascota.add(lblNewLabel_4_1_1);
		
		txtMascotaNombre = new JTextField();
		txtMascotaNombre.setColumns(10);
		txtMascotaNombre.setBounds(292, 145, 97, 20);
		registroMascota.add(txtMascotaNombre);
		
		txtMascotaRaza = new JTextField();
		txtMascotaRaza.setColumns(10);
		txtMascotaRaza.setBounds(292, 195, 97, 20);
		registroMascota.add(txtMascotaRaza);
		
		txtMascotaEspecie = new JTextField();
		txtMascotaEspecie.setColumns(10);
		txtMascotaEspecie.setBounds(472, 145, 97, 20);
		registroMascota.add(txtMascotaEspecie);
		
		txtMascotaEdad = new JTextField();
		txtMascotaEdad.setColumns(10);
		txtMascotaEdad.setBounds(472, 195, 97, 20);
		registroMascota.add(txtMascotaEdad);
		
		txtMascotaDni = new JTextField();
		txtMascotaDni.setColumns(10);
		txtMascotaDni.setBounds(292, 251, 97, 20);
		registroMascota.add(txtMascotaDni);
		
		JButton btnCancelar_1_1 = new JButton("Cancelar");
		btnCancelar_1_1.setBounds(370, 298, 89, 23);
		registroMascota.add(btnCancelar_1_1);
		
		JButton btnMascotaRegistrar = new JButton("Registrar");
		btnMascotaRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txtMascotaNombre.getText();
				String especie=txtMascotaEspecie.getText();
				String raza=txtMascotaRaza.getText();
				int edad=Integer.parseInt(txtMascotaEdad.getText());
				int dni=Integer.parseInt(txtMascotaDni.getText());
				Mascota m = new Mascota();
				m.setNombre(nombre);
				m.setRaza(raza);
				m.setEspecie(especie);
				m.setEdad(edad);
				m.setDniCliente(dni);
				mascotaDAO.registrar(m);
			}
		});
		btnMascotaRegistrar.setBounds(480, 298, 89, 23);
		registroMascota.add(btnMascotaRegistrar);
		
		JPanel consultaMascota = new JPanel();
		consultaMascota.setLayout(null);
		tabbedPane_m.addTab("Consulta", null, consultaMascota, null);
		
		JTextArea txtMascotaArea = new JTextArea();
		txtMascotaArea.setBounds(10, 67, 811, 434);
		consultaMascota.add(txtMascotaArea);
		
		JButton btnMascotaMostrar = new JButton("Mostrar");
		btnMascotaMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMascotaArea.setText("CODIGO\tNOMBRE\tESPECIE\tRAZA\tEDAD\tDNI\tDUEÑO_N");
				List<Mascota> mascotas= mascotaDAO.consulta();
				for(Mascota m : mascotas) {
					txtMascotaArea.append("\n"+m.getIdMascota()+
										  "\t"+m.getNombre()+
										  "\t"+m.getEspecie()+
										  "\t"+m.getRaza()+
										  "\t"+m.getEdad()+
										  "\t"+m.getClienteDni()+
										  "\t"+m.getClienteNombre());
				}
			}
		});
		btnMascotaMostrar.setBounds(360, 512, 89, 23);
		consultaMascota.add(btnMascotaMostrar);
		
		JPanel productos = new JPanel();
		productos.setLayout(null);
		tabbedPane.addTab("Producto", null, productos, null);
		
		JTabbedPane tabbedPane_p = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_p.setBounds(10, 11, 836, 574);
		productos.add(tabbedPane_p);
		
		JPanel registroProducto = new JPanel();
		registroProducto.setLayout(null);
		tabbedPane_p.addTab("Registro", null, registroProducto, null);
		
		JLabel lblNewLabel_6 = new JLabel("Producto");
		lblNewLabel_6.setBounds(197, 148, 58, 14);
		registroProducto.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marca");
		lblNewLabel_1_2.setBounds(416, 148, 63, 14);
		registroProducto.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Precio");
		lblNewLabel_2_2.setBounds(197, 198, 58, 14);
		registroProducto.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("Categoria");
		lblNewLabel_3_2.setBounds(416, 198, 63, 14);
		registroProducto.add(lblNewLabel_3_2);
		
		txtProductoMarca = new JTextField();
		txtProductoMarca.setColumns(10);
		txtProductoMarca.setBounds(484, 145, 120, 20);
		registroProducto.add(txtProductoMarca);
		
		txtProductoPrecio = new JTextField();
		txtProductoPrecio.setColumns(10);
		txtProductoPrecio.setBounds(265, 195, 120, 20);
		registroProducto.add(txtProductoPrecio);
		
		txtProductoCategoria = new JTextField();
		txtProductoCategoria.setColumns(10);
		txtProductoCategoria.setBounds(484, 195, 120, 20);
		registroProducto.add(txtProductoCategoria);
		
		txtProductoNombre = new JTextField();
		txtProductoNombre.setColumns(10);
		txtProductoNombre.setBounds(265, 145, 120, 20);
		registroProducto.add(txtProductoNombre);
		
		JButton btnNewButton_4 = new JButton("Registrar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String producto=txtProductoNombre.getText();
				String marca=txtProductoMarca.getText();
				double precio=Double.parseDouble(txtProductoPrecio.getText());
				String categoria=txtProductoCategoria.getText();
				Producto p=new Producto();
				p.setProducto(producto);
				p.setMarca(marca);
				p.setPrecio(precio);
				p.setCategoria(categoria);
				productoDAO.registrar(p);
			}
		});
		btnNewButton_4.setBounds(498, 256, 89, 23);
		registroProducto.add(btnNewButton_4);
		
		JButton btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar_2.setBounds(384, 256, 89, 23);
		registroProducto.add(btnCancelar_2);
		
		JPanel consultaProducto = new JPanel();
		consultaProducto.setLayout(null);
		tabbedPane_p.addTab("Consulta", null, consultaProducto, null);
		
		JTextArea txtProductoArea = new JTextArea();
		txtProductoArea.setBounds(10, 67, 811, 434);
		consultaProducto.add(txtProductoArea);
		
		JButton btnProductoMostrar = new JButton("Mostrar");
		btnProductoMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtProductoArea.setText("CODIGO\tPRODUCTO\tMARCA\tPRECIO\tCATEGORIA");
				List<Producto> productos=productoDAO.consultar();
				for (Producto p : productos) {
					txtProductoArea.append("\n"+p.getId_producto()+
										   "\t"+p.getProducto()+
										   "\t"+p.getMarca()+
										   "\t"+p.getPrecio()+
										   "\t"+p.getCategoria());
				}
				/*
				txtArea.setText("");
				List<Cliente> clientes= clienteDAO.consultar();
				for(Cliente c : clientes) {
					txtArea.append("\n"+c.getNombres()+
							       "\t"+c.getApellidos()+
							       "\t"+c.getTelefono()+
							       "\t"+c.getDireccion()+
							       "\t"+c.getDni());
				}
				*/
			}
		});
		btnProductoMostrar.setBounds(360, 512, 89, 23);
		consultaProducto.add(btnProductoMostrar);
		
		JPanel ventas = new JPanel();
		tabbedPane.addTab("Ventas", null, ventas, null);
		ventas.setLayout(null);
		
		JTabbedPane tabbedPane_v = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_v.setBounds(10, 11, 836, 574);
		ventas.add(tabbedPane_v);
		
		JPanel registroVenta = new JPanel();
		registroVenta.setLayout(null);
		tabbedPane_v.addTab("Registro", null, registroVenta, null);
		
		JLabel lblNewLabel_5 = new JLabel("DNI del Cliente");
		lblNewLabel_5.setBounds(197, 148, 104, 14);
		registroVenta.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Código Producto");
		lblNewLabel_2_1.setBounds(197, 198, 120, 14);
		registroVenta.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Cantidad");
		lblNewLabel_4_1.setBounds(197, 248, 104, 14);
		registroVenta.add(lblNewLabel_4_1);
		
		txtDniVenta = new JTextField();
		txtDniVenta.setColumns(10);
		txtDniVenta.setBounds(327, 145, 120, 20);
		registroVenta.add(txtDniVenta);
		
		txtCodigoProductoVenta = new JTextField();
		txtCodigoProductoVenta.setColumns(10);
		txtCodigoProductoVenta.setBounds(327, 195, 120, 20);
		registroVenta.add(txtCodigoProductoVenta);
		
		txtCantidadVenta = new JTextField();
		txtCantidadVenta.setColumns(10);
		txtCantidadVenta.setBounds(327, 245, 120, 20);
		registroVenta.add(txtCantidadVenta);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setBounds(390, 325, 89, 23);
		registroVenta.add(btnCancelar_1);
		
		JButton btnNewButton_3 = new JButton("Registrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dni=Integer.parseInt(txtDniVenta.getText());
				int codigoProd=Integer.parseInt(txtCodigoProductoVenta.getText());
				int cantidad=Integer.parseInt(txtCantidadVenta.getText());
				Venta v=new Venta();
				v.setDniCliente(dni);
				v.setIdProducto(codigoProd);
				v.setCantidad(cantidad);
				ventasDAO.registrar(v);
			}
		});
		btnNewButton_3.setBounds(504, 325, 89, 23);
		registroVenta.add(btnNewButton_3);
		
		JPanel consultaVenta = new JPanel();
		consultaVenta.setLayout(null);
		tabbedPane_v.addTab("Consulta", null, consultaVenta, null);
		
		JTextArea txtVentaArea = new JTextArea();
		txtVentaArea.setBounds(10, 67, 811, 434);
		consultaVenta.add(txtVentaArea);
		
		JButton btnVentaMostar = new JButton("Mostrar");
		btnVentaMostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVentaArea.setText("CODIGO\tFECHA\tDNI\tPRODUCTO\tPRECIO\tCANTIDAD\tSUBTOTAL\tIGV\tTOTAL");
				List<Venta> ventas=ventasDAO.consultar();
				for(Venta v : ventas) {
					txtVentaArea.append("\n"+v.getIdVenta()+
										"             "+v.getFechaVenta()+
										"\t"+v.getDniCliente()+
										"\t"+v.getProducto()+
										"\t"+v.getPrecio()+
										"\t"+v.getCantidad()+
										"\t"+v.getSubtotal()+
										"\t"+v.getIgv()+
										"\t"+v.getTotal());
				}
			}
		});
		btnVentaMostar.setBounds(360, 512, 89, 23);
		consultaVenta.add(btnVentaMostar);
		
		JPanel servicios = new JPanel();
		servicios.setLayout(null);
		tabbedPane.addTab("Servicios", null, servicios, null);
		
		JTabbedPane tabbedPane_m_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_m_2.setBounds(10, 11, 836, 574);
		servicios.add(tabbedPane_m_2);
		
		JPanel registroMascota_1 = new JPanel();
		registroMascota_1.setLayout(null);
		tabbedPane_m_2.addTab("Registro", null, registroMascota_1, null);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Tipo de servicio");
		lblNewLabel_5_1_1.setBounds(197, 148, 129, 14);
		registroMascota_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("DNI Cliente");
		lblNewLabel_2_1_1_1.setBounds(197, 239, 129, 14);
		registroMascota_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("Código mascota");
		lblNewLabel_2_1_1_1_2.setBounds(197, 194, 129, 14);
		registroMascota_1.add(lblNewLabel_2_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_1_2_2 = new JLabel("Código Veterinario");
		lblNewLabel_2_1_1_1_2_2.setBounds(197, 288, 129, 14);
		registroMascota_1.add(lblNewLabel_2_1_1_1_2_2);
		
		txtServiciosDni = new JTextField();
		txtServiciosDni.setColumns(10);
		txtServiciosDni.setBounds(358, 236, 97, 20);
		registroMascota_1.add(txtServiciosDni);
		
		txtServiciosCodigoV = new JTextField();
		txtServiciosCodigoV.setColumns(10);
		txtServiciosCodigoV.setBounds(358, 285, 97, 20);
		registroMascota_1.add(txtServiciosCodigoV);
		
		txtServiciosTipo = new JTextField();
		txtServiciosTipo.setColumns(10);
		txtServiciosTipo.setBounds(358, 145, 97, 20);
		registroMascota_1.add(txtServiciosTipo);
		
		txtServiciosCodigoM = new JTextField();
		txtServiciosCodigoM.setColumns(10);
		txtServiciosCodigoM.setBounds(358, 191, 97, 20);
		registroMascota_1.add(txtServiciosCodigoM);
		
		JButton btnServiciosCancelar = new JButton("Cancelar");
		btnServiciosCancelar.setBounds(366, 343, 89, 23);
		registroMascota_1.add(btnServiciosCancelar);
		
		JButton btnServiciosRegistrar = new JButton("Registrar");
		btnServiciosRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo=txtServiciosTipo.getText();
				int dni=Integer.parseInt(txtServiciosDni.getText());
				int codV=Integer.parseInt(txtServiciosCodigoV.getText());
				int codM=Integer.parseInt(txtServiciosCodigoM.getText());
				Servicio s=new Servicio();
				s.setTipoServicio(tipo);
				s.setDniCliente(dni);
				s.setTipoServicio(tipo);
				s.setIdMascota(codM);
				s.setIdVeterinario(codV);
				servicioDAO.registrar(s);
			}
		});
		btnServiciosRegistrar.setBounds(471, 343, 89, 23);
		registroMascota_1.add(btnServiciosRegistrar);
		
		JPanel consultaProducto_1 = new JPanel();
		consultaProducto_1.setLayout(null);
		tabbedPane_m_2.addTab("Consulta", null, consultaProducto_1, null);
		
		JTextArea txtServiciosArea = new JTextArea();
		txtServiciosArea.setBounds(10, 67, 811, 434);
		consultaProducto_1.add(txtServiciosArea);
		
		JButton btnProductoMostrar_1 = new JButton("Mostrar");
		btnProductoMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtServiciosArea.setText("CODIGO\tFECHA\tTIPO\tMASCOTA\tDNI\tCLIENTE\tVETERINARIO");
				List<Servicio> servicios=servicioDAO.consultar();
				for(Servicio s:servicios) {
					txtServiciosArea.append("\n"+s.getIdServicio()+
											"             "+s.getFechaServicio()+
											"\t"+s.getTipoServicio()+
											"\t"+s.getNombreMascota()+
											"\t"+s.getDniCliente()+
											"\t"+s.getClienteTelefono()+
											"\t"+s.getNombreVeterinario());
				}
			}
		});
		btnProductoMostrar_1.setBounds(360, 512, 89, 23);
		consultaProducto_1.add(btnProductoMostrar_1);
		
		JPanel veterinarios_1 = new JPanel();
		veterinarios_1.setLayout(null);
		tabbedPane.addTab("Veterinarios", null, veterinarios_1, null);
		
		JTabbedPane tabbedPane_m_2_3_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_m_2_3_1.setBounds(10, 11, 836, 574);
		veterinarios_1.add(tabbedPane_m_2_3_1);
		
		JPanel registroCliente_2 = new JPanel();
		registroCliente_2.setLayout(null);
		tabbedPane_m_2_3_1.addTab("Registro", null, registroCliente_2, null);
		
		JLabel lblNewLabel_7 = new JLabel("Nombres");
		lblNewLabel_7.setBounds(197, 148, 58, 14);
		registroCliente_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1_3 = new JLabel("Apellidos");
		lblNewLabel_1_3.setBounds(428, 145, 63, 14);
		registroCliente_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefono");
		lblNewLabel_2_3.setBounds(197, 198, 58, 14);
		registroCliente_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Direccion");
		lblNewLabel_3_1.setBounds(428, 195, 63, 14);
		registroCliente_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("DNI");
		lblNewLabel_4_2.setBounds(197, 248, 46, 14);
		registroCliente_2.add(lblNewLabel_4_2);
		
		txtVeterinariosNombres = new JTextField();
		txtVeterinariosNombres.setColumns(10);
		txtVeterinariosNombres.setBounds(277, 142, 120, 20);
		registroCliente_2.add(txtVeterinariosNombres);
		
		txtVeterinariosApellidos = new JTextField();
		txtVeterinariosApellidos.setColumns(10);
		txtVeterinariosApellidos.setBounds(496, 142, 120, 20);
		registroCliente_2.add(txtVeterinariosApellidos);
		
		txtVeterinariosTelefono = new JTextField();
		txtVeterinariosTelefono.setColumns(10);
		txtVeterinariosTelefono.setBounds(277, 192, 120, 20);
		registroCliente_2.add(txtVeterinariosTelefono);
		
		txtVeterinariosDni = new JTextField();
		txtVeterinariosDni.setColumns(10);
		txtVeterinariosDni.setBounds(277, 242, 120, 20);
		registroCliente_2.add(txtVeterinariosDni);
		
		txtVeterinariosDireccion = new JTextField();
		txtVeterinariosDireccion.setColumns(10);
		txtVeterinariosDireccion.setBounds(496, 192, 120, 20);
		registroCliente_2.add(txtVeterinariosDireccion);
		
		txtVeterinariosSueldo = new JTextField();
		txtVeterinariosSueldo.setColumns(10);
		txtVeterinariosSueldo.setBounds(496, 242, 120, 20);
		registroCliente_2.add(txtVeterinariosSueldo);
		
		txtVeterinariosCargo = new JTextField();
		txtVeterinariosCargo.setColumns(10);
		txtVeterinariosCargo.setBounds(277, 299, 120, 20);
		registroCliente_2.add(txtVeterinariosCargo);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Sueldo");
		lblNewLabel_3_1_1.setBounds(428, 245, 63, 14);
		registroCliente_2.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Cargos");
		lblNewLabel_4_2_1.setBounds(197, 302, 70, 14);
		registroCliente_2.add(lblNewLabel_4_2_1);
		
		JButton btnVeterinariosRegistrar = new JButton("Registrar");
		btnVeterinariosRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombres=txtVeterinariosNombres.getText();
				String apellidos=txtVeterinariosApellidos.getText();
				int telefono=Integer.parseInt(txtVeterinariosTelefono.getText());
				String direccion=txtVeterinariosDireccion.getText();
				int dni=Integer.parseInt(txtVeterinariosDni.getText());
				String cargo=txtVeterinariosCargo.getText();
				double sueldo=Double.parseDouble(txtVeterinariosSueldo.getText());
				Veterinario v=new Veterinario();
				v.setNombre(nombres);
				v.setApellido(apellidos);
				v.setTelefono(telefono);
				v.setDireccion(direccion);
				v.setDni(dni);
				v.setSueldo(sueldo);
				v.setCargo(cargo);
				veterinarioDAO.registrar(v);;
			}
		});
		
		btnVeterinariosRegistrar.setBounds(515, 375, 89, 23);
		registroCliente_2.add(btnVeterinariosRegistrar);
		
		JButton btnVeterinariosCancelar = new JButton("Cancelar");
		btnVeterinariosCancelar.setBounds(390, 375, 89, 23);
		registroCliente_2.add(btnVeterinariosCancelar);
		
		JPanel consultaCliente_2 = new JPanel();
		consultaCliente_2.setLayout(null);
		tabbedPane_m_2_3_1.addTab("Consulta", null, consultaCliente_2, null);
		
		JTextArea txtVeterinariosArea = new JTextArea();
		txtVeterinariosArea.setBounds(10, 67, 811, 434);
		consultaCliente_2.add(txtVeterinariosArea);
		
		JButton btnMostrar_2 = new JButton("Mostrar");
		btnMostrar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtVeterinariosArea.setText("CODIGO\tNOMBRES\tAPELLIDOS\tTELEFONO\tDIRECCION\tDNI\tCARGO\tSUELDO");
				List<Veterinario> veterinarios = veterinarioDAO.consultar();
				for(Veterinario vet : veterinarios) {
				txtVeterinariosArea.append("\n"+vet.getIdVet()+
										  "\t"+vet.getNombre()+
							  			  "\t"+vet.getApellido()+
							              "\t"+vet.getTelefono()+
							              "\t"+vet.getDireccion()+
							              "\t"+vet.getDni()+
							              "\t"+vet.getCargo()+
							              "\t"+vet.getSueldo());
				}
			}
		});
		btnMostrar_2.setBounds(360, 512, 89, 23);
		consultaCliente_2.add(btnMostrar_2);
		
		JPanel adopciones_1 = new JPanel();
		adopciones_1.setLayout(null);
		tabbedPane.addTab("Adopcion", null, adopciones_1, null);
		
		JTabbedPane tabbedPane_m_2_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_m_2_1.setBounds(10, 11, 836, 574);
		adopciones_1.add(tabbedPane_m_2_1);
		
		JPanel registroCliente_1 = new JPanel();
		registroCliente_1.setLayout(null);
		tabbedPane_m_2_1.addTab("Registro", null, registroCliente_1, null);
		
		JLabel lblFechaadopcion = new JLabel("DNI_Cliente");
		lblFechaadopcion.setBounds(197, 148, 89, 14);
		registroCliente_1.add(lblFechaadopcion);
		
		JLabel lblNewLabel_1_1 = new JLabel("Código de mascota");
		lblNewLabel_1_1.setBounds(197, 198, 127, 14);
		registroCliente_1.add(lblNewLabel_1_1);
		
		txtAdopcionDni = new JTextField();
		txtAdopcionDni.setColumns(10);
		txtAdopcionDni.setBounds(334, 145, 145, 20);
		registroCliente_1.add(txtAdopcionDni);
		
		txtAdopcionCodigoM = new JTextField();
		txtAdopcionCodigoM.setColumns(10);
		txtAdopcionCodigoM.setBounds(334, 195, 145, 20);
		registroCliente_1.add(txtAdopcionCodigoM);
		
		JButton btnAdopcionRegistrar = new JButton("Registrar");
		btnAdopcionRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dni=Integer.parseInt(txtAdopcionDni.getText());
				int codigo=Integer.parseInt(txtAdopcionCodigoM.getText());
				Adopcion a=new Adopcion();
				a.setDniCliente(dni);
				a.setIdMascota(codigo);
				adopcionDAO.registrar(a);
			}
		});
		btnAdopcionRegistrar.setBounds(500, 265, 89, 23);
		registroCliente_1.add(btnAdopcionRegistrar);
		
		JButton btnCancelar_3 = new JButton("Cancelar");
		btnCancelar_3.setBounds(390, 265, 89, 23);
		registroCliente_1.add(btnCancelar_3);
		
		JPanel consultaCliente_1 = new JPanel();
		consultaCliente_1.setLayout(null);
		tabbedPane_m_2_1.addTab("Consulta", null, consultaCliente_1, null);
		
		JTextArea txtAdopcionArea = new JTextArea();
		txtAdopcionArea.setBounds(10, 67, 811, 434);
		consultaCliente_1.add(txtAdopcionArea);
		
		JButton btnMostrar_1 = new JButton("Mostrar");
		btnMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAdopcionArea.setText("CODIGO\tFECHA\tMASCOTA\tESPECIE\tDNI\tNOMBRE");
				List<Adopcion> adopciones=adopcionDAO.consultar();
				for(Adopcion a : adopciones) {
					txtAdopcionArea.append("\n"+a.getIdAdopcion()+
										   "             "+a.getFechaAdopcion()+
										   "\t"+a.getNombreMascota()+
										   "\t"+a.getEspecie()+
										   "\t"+a.getDniCliente()+
										   "\t"+a.getClienteNombre());
				}
			}
		});
		btnMostrar_1.setBounds(360, 512, 89, 23);
		consultaCliente_1.add(btnMostrar_1);
		
		JPanel adopMascotas_ = new JPanel();
		adopMascotas_.setLayout(null);
		tabbedPane.addTab("AdopMascotas", null, adopMascotas_, null);
		
		JTabbedPane tabbedPane_m_2_3_1_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_m_2_3_1_1.setBounds(10, 11, 836, 574);
		adopMascotas_.add(tabbedPane_m_2_3_1_1);
		
		JPanel registroAdopMascota = new JPanel();
		registroAdopMascota.setLayout(null);
		tabbedPane_m_2_3_1_1.addTab("Registro", null, registroAdopMascota, null);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Edad");
		lblNewLabel_4_1_1_1_1_1.setBounds(385, 198, 46, 14);
		registroAdopMascota.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Nombre");
		lblNewLabel_5_1_1_1.setBounds(197, 148, 89, 14);
		registroAdopMascota.add(lblNewLabel_5_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Raza");
		lblNewLabel_2_1_1_1_1.setBounds(197, 198, 79, 14);
		registroAdopMascota.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_2_1 = new JLabel("Especie");
		lblNewLabel_4_1_1_2_1.setBounds(385, 148, 46, 14);
		registroAdopMascota.add(lblNewLabel_4_1_1_2_1);
		
		txtAdopMascotasNombre = new JTextField();
		txtAdopMascotasNombre.setColumns(10);
		txtAdopMascotasNombre.setBounds(270, 145, 97, 20);
		registroAdopMascota.add(txtAdopMascotasNombre);
		
		txtAdopMascotasRaza = new JTextField();
		txtAdopMascotasRaza.setColumns(10);
		txtAdopMascotasRaza.setBounds(270, 195, 97, 20);
		registroAdopMascota.add(txtAdopMascotasRaza);
		
		txtAdopMascotasEspecie = new JTextField();
		txtAdopMascotasEspecie.setColumns(10);
		txtAdopMascotasEspecie.setBounds(441, 145, 97, 20);
		registroAdopMascota.add(txtAdopMascotasEspecie);
		
		txtAdopMascotasEdad = new JTextField();
		txtAdopMascotasEdad.setColumns(10);
		txtAdopMascotasEdad.setBounds(441, 195, 97, 20);
		registroAdopMascota.add(txtAdopMascotasEdad);
		
		JButton btnCancelar_1_1_1_1 = new JButton("Cancelar");
		btnCancelar_1_1_1_1.setBounds(371, 253, 89, 23);
		registroAdopMascota.add(btnCancelar_1_1_1_1);
		
		JButton btnAdopMascotasRegistrar = new JButton("Registrar");
		btnAdopMascotasRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txtAdopMascotasNombre.getText();
				String especie=txtAdopMascotasEspecie.getText();
				String raza=txtAdopMascotasRaza.getText();
				int edad=Integer.parseInt(txtAdopMascotasEdad.getText());
				AdopMascota am = new AdopMascota();
				am.setNombre(nombre);
				am.setRaza(raza);
				am.setEspecie(especie);
				am.setEdad(edad);
				adopMascotasDAO.registrar(am);
			}
		});
		btnAdopMascotasRegistrar.setBounds(481, 253, 89, 23);
		registroAdopMascota.add(btnAdopMascotasRegistrar);
		
		JPanel consultaAdopMascota = new JPanel();
		consultaAdopMascota.setLayout(null);
		tabbedPane_m_2_3_1_1.addTab("Consulta", null, consultaAdopMascota, null);
		
		JTextArea txtAdopMascotaArea = new JTextArea();
		txtAdopMascotaArea.setBounds(10, 67, 811, 434);
		consultaAdopMascota.add(txtAdopMascotaArea);
		
		JButton btnProductoMostrar_1_1 = new JButton("Mostrar");
		btnProductoMostrar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAdopMascotaArea.setText("CODIGO\tNOMBRE\tESPECIE\tRAZA\tEDAD");
				List<AdopMascota> adopMascotas = adopMascotasDAO.consultar();
				for (AdopMascota am : adopMascotas) {
					txtAdopMascotaArea.append("\n"+am.getIdAdopMascota()+
											  "\t"+am.getNombre()+
											  "\t"+am.getEspecie()+
											  "\t"+am.getRaza()+
											  "\t"+am.getEdad());
				}
			}
		});
		btnProductoMostrar_1_1.setBounds(360, 512, 89, 23);
		consultaAdopMascota.add(btnProductoMostrar_1_1);
	}
}
