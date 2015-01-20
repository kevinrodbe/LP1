package repaso.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import repaso.bean.EventoBean;
import repaso.controlador.EventoAction;
import repaso.sort.SortCapacidad;
import repaso.sort.SortNombreEvento;
import repaso.sort.SortNombreLocal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class frmConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCapacidad;
	private JTextField txtCapacidadInicio;
	private JTextField txtCapacidadFinal;
	private JButton btnConsultar;
	private JLabel lblOrdenarPor;
	private JRadioButton rdbtnNombreEvento;
	private JRadioButton rdbtnNombreLocal;
	private JRadioButton rdbtnCapacidad;
	private JCheckBox chckbxAscendente;
	private JScrollPane scpPanel;
	private JTable tblLista;
	private ButtonGroup grupo;
	
	List<EventoBean> lista = new ArrayList<EventoBean>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsulta frame = new frmConsulta();
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
	public frmConsulta() {
		setTitle("Consulta de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			// Crear un grupo para los radiobuttons
			grupo = new ButtonGroup();
		}
		{
			lblCapacidad = new JLabel("Capacidad");
			lblCapacidad.setBounds(10, 11, 76, 14);
			contentPane.add(lblCapacidad);
		}
		{
			txtCapacidadInicio = new JTextField();
			txtCapacidadInicio.setBounds(96, 8, 62, 20);
			contentPane.add(txtCapacidadInicio);
			txtCapacidadInicio.setColumns(10);
		}
		{
			txtCapacidadFinal = new JTextField();
			txtCapacidadFinal.setBounds(168, 8, 62, 20);
			contentPane.add(txtCapacidadFinal);
			txtCapacidadFinal.setColumns(10);
		}
		{
			btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(this);
			btnConsultar.setBounds(243, 7, 89, 23);
			contentPane.add(btnConsultar);
		}
		{
			lblOrdenarPor = new JLabel("Ordenar Por:");
			lblOrdenarPor.setBounds(10, 47, 96, 14);
			contentPane.add(lblOrdenarPor);
		}
		{
			rdbtnNombreEvento = new JRadioButton("Nombre Evento");
			rdbtnNombreEvento.addActionListener(this);
			rdbtnNombreEvento.setBounds(10, 68, 135, 23);
			grupo.add(rdbtnNombreEvento);
			contentPane.add(rdbtnNombreEvento);
		}
		{
			rdbtnNombreLocal = new JRadioButton("Nombre Local");
			rdbtnNombreLocal.addActionListener(this);
			rdbtnNombreLocal.setBounds(168, 68, 109, 23);
			grupo.add(rdbtnNombreLocal);
			contentPane.add(rdbtnNombreLocal);
		}
		{
			rdbtnCapacidad = new JRadioButton("Capacidad");
			rdbtnCapacidad.addActionListener(this);
			rdbtnCapacidad.setBounds(312, 68, 109, 23);
			grupo.add(rdbtnCapacidad);
			contentPane.add(rdbtnCapacidad);
		}
		{
			chckbxAscendente = new JCheckBox("Ascendente");
			chckbxAscendente.addActionListener(this);
			chckbxAscendente.setSelected(true);
			chckbxAscendente.setBounds(497, 68, 97, 23);
			contentPane.add(chckbxAscendente);
		}
		{
			scpPanel = new JScrollPane();
			scpPanel.setBounds(20, 98, 703, 153);
			contentPane.add(scpPanel);
			{
				tblLista = new JTable();
				tblLista.setModel(new DefaultTableModel(
						new Object[][]{}, 
						new String[]{"Id", "Evento", "Local", 
								"Fec Inicio", "Fec Fin", "Capacidad",
								"Web", "Contacto"}));
				scpPanel.setViewportView(tblLista);
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == chckbxAscendente) {
			chckbxAscendenteActionPerformed(arg0);
		}
		if (arg0.getSource() == rdbtnCapacidad) {
			rdbtnCapacidadActionPerformed(arg0);
		}
		if (arg0.getSource() == rdbtnNombreLocal) {
			rdbtnNombreLocalActionPerformed(arg0);
		}
		if (arg0.getSource() == rdbtnNombreEvento) {
			rdbtnNombreEventoActionPerformed(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			btnConsultarActionPerformed(arg0);
		}
	}
	protected void btnConsultarActionPerformed(ActionEvent arg0) {
		
		int capInicio = Integer.parseInt(txtCapacidadInicio.getText());
		int capFinal = Integer.parseInt(txtCapacidadFinal.getText());
		
		lista = new EventoAction()
					.consultarPorCapacidad(capInicio, capFinal);
		listar();
	}

	private void listar() {
		DefaultTableModel model =
						(DefaultTableModel) tblLista.getModel();
		model.getDataVector().clear();
		
		if(lista != null)
		{
			for (EventoBean bean : lista) {
				Object row[] = {bean.getIdEvento(), bean.getNombre(), 
						bean.getNombreLocal(), bean.getFechaInicio(), 
						bean.getFechaFin(), bean.getCapacidad(), 
						bean.getUrl(), bean.getEmailContacto()};
				model.addRow(row);
			}
		}
		
	}
	protected void rdbtnNombreEventoActionPerformed(ActionEvent arg0) {
		Collections.sort(lista, new SortNombreEvento());
		if(! chckbxAscendente.isSelected())
			Collections.reverse(lista);
		listar();
	}
	protected void rdbtnNombreLocalActionPerformed(ActionEvent arg0) {
		Collections.sort(lista, new SortNombreLocal());
		if(! chckbxAscendente.isSelected())
			Collections.reverse(lista);
		listar();
	}
	protected void rdbtnCapacidadActionPerformed(ActionEvent arg0) {
		Collections.sort(lista, new SortCapacidad());
		if(! chckbxAscendente.isSelected())
			Collections.reverse(lista);
		listar();
	}
	protected void chckbxAscendenteActionPerformed(ActionEvent arg0) {
		if(rdbtnNombreEvento.isSelected())
			rdbtnNombreEventoActionPerformed(arg0);
		if(rdbtnNombreLocal.isSelected())
			rdbtnNombreLocalActionPerformed(arg0);
		if(rdbtnCapacidad.isSelected())
			rdbtnCapacidadActionPerformed(arg0);
	}
}






