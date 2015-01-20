package propuesto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FrmOrdenamiento extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea txtS;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JCheckBox chkTipo;
	private JLabel lblOrdenamiento;
	private JRadioButton btnAño;
	private JRadioButton rbtApellido;
	private ButtonGroup btnGrupo;
	private JRadioButton rbtNombre;
	private JTextField txtApellido;
	private JLabel jLabel2;
	private JTextField txtNombre;
	private JTextField txtAno;
	private JButton btnIngresar;
	private JLabel jLabel1;

	

	public FrmOrdenamiento() {

		getContentPane().setLayout(null);

		txtS = new JTextArea();
		getContentPane().add(txtS);
		txtS.setBounds(33, 230, 441, 101);
		txtS.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1, false));

		jLabel1 = new JLabel();
		getContentPane().add(jLabel1);
		jLabel1.setText("Registro de Alumno");
		jLabel1.setBounds(42, 12, 432, 24);
		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

		btnGrupo = new ButtonGroup();

		btnIngresar = new JButton();
		getContentPane().add(btnIngresar);
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(381, 55, 127, 21);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnIngresarActionPerformed(evt);
			}
		});

		txtAno = new JTextField();
		getContentPane().add(txtAno);
		txtAno.setBounds(123, 121, 231, 21);

		txtNombre = new JTextField();
		getContentPane().add(txtNombre);
		txtNombre.setBounds(123, 55, 231, 21);

		jLabel2 = new JLabel();
		getContentPane().add(jLabel2);
		jLabel2.setText("Nombre");
		jLabel2.setBounds(33, 58, 54, 14);

		jLabel3 = new JLabel();
		getContentPane().add(jLabel3);
		jLabel3.setText("Año");
		jLabel3.setBounds(33, 124, 90, 14);

		jLabel4 = new JLabel();
		getContentPane().add(jLabel4);
		jLabel4.setText("Apellido");
		jLabel4.setBounds(33, 89, 66, 14);

		txtApellido = new JTextField();
		getContentPane().add(txtApellido);
		txtApellido.setBounds(123, 86, 225, 21);

		rbtNombre = new JRadioButton();
		getContentPane().add(rbtNombre);
		rbtNombre.setText("Nombre");
		rbtNombre.setBounds(37, 203, 75, 18);
		btnGrupo.add(rbtNombre);
		rbtNombre.setSelected(true);
		rbtNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtNombreActionPerformed(evt);
			}
		});

		rbtApellido = new JRadioButton();
		getContentPane().add(rbtApellido);
		rbtApellido.setText("Apellido");
		rbtApellido.setBounds(136, 203, 71, 18);
		btnGrupo.add(rbtApellido);
		rbtApellido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				rbtApellidoActionPerformed(evt);
			}
		});

		lblOrdenamiento = new JLabel();
		lblOrdenamiento.setText("Ordenamiento por Campo");
		lblOrdenamiento.setBounds(37, 166, 237, 27);
		lblOrdenamiento.setFont(new java.awt.Font("Tahoma", 1, 18));

		chkTipo = new JCheckBox();
		chkTipo.setText("Acendente");
		chkTipo.setBounds(354, 203, 70, 18);
		chkTipo.setSelected(true);

		btnAño = new JRadioButton();
		getContentPane().add(btnAño);
		getContentPane().add(lblOrdenamiento);
		getContentPane().add(chkTipo);
		chkTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				chkTipoItemStateChanged(evt);
			}
		});

		btnAño.setText("Año");
		btnAño.setBounds(246, 203, 71, 18);
		btnGrupo.add(btnAño);
		btnAño.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnAñoActionPerformed(evt);
			}
		});

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 450);

	}

	public static void main(String[] args) {
		new FrmOrdenamiento();
	}

	private void rbtNombreActionPerformed(ActionEvent evt) {
		
	}

	private void rbtApellidoActionPerformed(ActionEvent evt) {
		
	}

	private void btnAñoActionPerformed(ActionEvent evt) {
		
	}

	private void btnIngresarActionPerformed(ActionEvent evt) {
		
	}

	private void chkTipoItemStateChanged(ItemEvent evt) {
		
	}

	

}
