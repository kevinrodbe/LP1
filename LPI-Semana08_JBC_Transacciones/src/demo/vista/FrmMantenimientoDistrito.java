package demo.vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import demo.controlador.DistritoAction;
import demo.entidad.DistritoBean;


public class FrmMantenimientoDistrito extends JFrame{

	private static final long serialVersionUID = -3651797356453172135L;
	private JLabel lblTitulo;
	private JLabel lblDescripcion;
	private JButton btnLimpiar;
	private JButton btnProcesar;
	private JTextField txtDescripcion;

	DistritoAction accion = new DistritoAction();
	
	public FrmMantenimientoDistrito(){
		
		getContentPane().setLayout(null);

		lblTitulo = new JLabel();
		getContentPane().add(lblTitulo);
		lblTitulo.setText("Registro de Distrito");
		lblTitulo.setBounds(12, 12, 484, 31);
		lblTitulo.setFont(new java.awt.Font("Arial",1,16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBackground(new java.awt.Color(255,255,255));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new java.awt.Color(0,0,255));

		lblDescripcion = new JLabel();
		getContentPane().add(lblDescripcion);
		lblDescripcion.setText("Descripcion");
		lblDescripcion.setBounds(12, 80, 90, 16);

		txtDescripcion = new JTextField();
		getContentPane().add(txtDescripcion);
		txtDescripcion.setBounds(118, 77, 167, 23);

		btnProcesar = new JButton();
		getContentPane().add(btnProcesar);
		btnProcesar.setText("Procesar");
		btnProcesar.setBounds(12, 139, 116, 29);
		btnProcesar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/Accept.gif")));
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnProcesarActionPerformed(evt);
			}
		});

		btnLimpiar = new JButton();
		getContentPane().add(btnLimpiar);
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setBounds(153, 139, 120, 29);
		btnLimpiar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("iconos/Down.gif")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLimpiarActionPerformed(evt);
			}
		});

		this.setSize(524, 253);
		setVisible(true);
		//elimine el proceso al cerrar el frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		new FrmMantenimientoDistrito();
	}
	
	private void btnProcesarActionPerformed(ActionEvent evt) {

		DistritoBean bean = new DistritoBean();
		bean.setDescripcion(txtDescripcion.getText().trim());
	
		int salida=  accion.insertaDistrito(bean);
		
		JOptionPane.showMessageDialog(this, "Insertados: " + salida);
		
	}
	
	private void btnLimpiarActionPerformed(ActionEvent evt) {
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();
	}

}
