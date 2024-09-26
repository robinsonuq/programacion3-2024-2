package empresa.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import empresa.controllers.CrudEmpleadoController;
import empresa.model.Empleado;
import empresa.model.Empresa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class GestionEmpleados {

	private JFrame frmGestionEmpleados;
	private JTextArea textArea;
	private JButton btnAgregarEmpleado;
	private JTextField textSalario;
	private JTextField textNombre;
	private JLabel label;
	private JTextField textCedula;
	private JLabel lblCedula;
	private JTextField textTelefono;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JTextField textCorreo;

	Empresa empresa = new Empresa("Mi empresa");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEmpleados window = new GestionEmpleados();
					window.frmGestionEmpleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionEmpleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionEmpleados = new JFrame();
		frmGestionEmpleados.setTitle("Gestion Empleados");
		frmGestionEmpleados.setBounds(100, 100, 450, 424);
		frmGestionEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionEmpleados.getContentPane().setLayout(null);
		
		 textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 217, 391, 157);
		frmGestionEmpleados.getContentPane().add(textArea);
		
		JButton btnMostrarEmpleados = new JButton("Mostrar Empleados");
		btnMostrarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CrudEmpleadoController crudEmpleadoController = new CrudEmpleadoController();
				LinkedList<Empleado> mostrarListaEmpleados = crudEmpleadoController.mostrarListaEmpleados();
				String emplados = "";
				for (Empleado empleado : mostrarListaEmpleados) {
					emplados += empleado.getNombre()+"\n";
				}
				textArea.setText(emplados);
			}
		});
		btnMostrarEmpleados.setBounds(284, 183, 117, 23);
		frmGestionEmpleados.getContentPane().add(btnMostrarEmpleados);
		
		btnAgregarEmpleado = new JButton("Agregar Empleado");
		btnAgregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nombre = textNombre.getText();
				String identificacion = textCedula.getText();
				double salario = Double.valueOf(textSalario.getText());
				String telefono = textTelefono.getText();
				String correo = textCorreo.getText();
				
				CrudEmpleadoController crudEmpleadoController = new CrudEmpleadoController();
				crudEmpleadoController.addEmpleado(empresa,new Empleado(nombre, identificacion, salario, telefono, correo));
				
			}
		});
		btnAgregarEmpleado.setBounds(107, 158, 152, 23);
		frmGestionEmpleados.getContentPane().add(btnAgregarEmpleado);
		
		JLabel lblNombre = new JLabel("Salario");
		lblNombre.setBounds(10, 58, 46, 14);
		frmGestionEmpleados.getContentPane().add(lblNombre);
		
		textSalario = new JTextField();
		textSalario.setBounds(10, 74, 152, 20);
		frmGestionEmpleados.getContentPane().add(textSalario);
		textSalario.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(10, 27, 152, 20);
		frmGestionEmpleados.getContentPane().add(textNombre);
		
		label = new JLabel("Nombre ");
		label.setBounds(10, 11, 46, 14);
		frmGestionEmpleados.getContentPane().add(label);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(204, 27, 152, 20);
		frmGestionEmpleados.getContentPane().add(textCedula);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(194, 11, 46, 14);
		frmGestionEmpleados.getContentPane().add(lblCedula);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(194, 74, 152, 20);
		frmGestionEmpleados.getContentPane().add(textTelefono);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(194, 58, 46, 14);
		frmGestionEmpleados.getContentPane().add(lblTelefono);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(194, 105, 46, 14);
		frmGestionEmpleados.getContentPane().add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(194, 121, 152, 20);
		frmGestionEmpleados.getContentPane().add(textCorreo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 152, 379, 2);
		frmGestionEmpleados.getContentPane().add(separator);
	}
}
