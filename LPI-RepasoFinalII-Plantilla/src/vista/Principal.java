package vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import controlador.Action;
import modelo.Bean;
public class Principal extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTable table;
	private JButton btnConsultar;
	/* atributos agregados */
	private JLabel lblTiempo;
	/**
	 * Launch the application.
	 */
	List<Bean >lista= new ArrayList<Bean>();
	private JComboBox comboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Consulta de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Consulta de Productos");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblTitulo.setBounds(149, 0, 308, 32);
		contentPane.add(lblTitulo);

		JLabel lblFiltro = new JLabel("Marca");
		lblFiltro.setBounds(10, 43, 57, 23);
		contentPane.add(lblFiltro);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(503, 43, 89, 23);
		contentPane.add(btnConsultar);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 104, 582, 15);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 582, 159);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"Descripción", "Precio", "Stock", "Marca" }) {
			Class[] columnTypes = new Class[] { String.class, String.class,
					String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));

		lblTiempo = new JLabel("");
		lblTiempo.setBackground(Color.ORANGE);
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTiempo.setForeground(Color.BLUE);
		lblTiempo.setBounds(10, 70, 396, 32);
		contentPane.add(lblTiempo);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] {
						"Clearasil Ultra",
						"Hope In A Jar For Dry Skin SPF",
						"Xyntha",
						"Octreotide acetate",
						"Aspen",
						"Breast Cyst and Discomforts",
						"gas relief",
						"Micardis",
						"Bumetanide",
						"eszopiclone",
						"ONDANSETRON HYDROCHLORIDE",
						"Ibutilide Fumarate",
						"BareMinerals Golden Deep matte",
						"Duloxetine",
						"Good Neighbor Pharmacy naproxen sodium",
						"Chlorpromazine Hydrochloride",
						"Fem Repair Non-Preg",
						"Buspirone HCl",
						"good sense antacid",
						"anti bacterial hand sanitizer",
						"Cephalexin",
						"CANCIDAS",
						"Hydrochlorothiazide",
						"Leader Lip Treatment",
						"Cover Fx BB Gel Mattifying Anti-Blemish G Light-Med",
						"ofloxacin",
						"Ceramide Lift And Firm Makeup Broad Spectrum Sunscreen SPF 15 Beige",
						"EROS EXTENDED LOVE",
						"PROVIGIL",
						"Ipratropium Bromide",
						"Buspirone Hydrochloride",
						"rHGH Complex",
						"Dandruff",
						"Sertraline Hydrochloride",
						"Clonazepam",
						"Cat Hair",
						"CELEBREX",
						"Time Frame Future Resist Foundation Broad Spectrum SPF 20",
						"Moore Medical MooreBrand Severe Cold Relief",
						"Plan B One-Step",
						"Family Care Advanced Formula Eye",
						"Good Neighbor Pharmacy Flu and Sore throat",
						"Lisinopril",
						"gemcitabine",
						"Ibuprofen",
						"CTx4 Gel 1100",
						"All Day Relief",
						"PANTO A",
						"VANCOMYCIN HYDROCHLORIDE",
						"Amoxicillin",
						"CHAMOMILLA",
						"Botrytis",
						"Prandin",
						"BioPhenolics",
						"Diazepam",
						"NATURCOKSINUM",
						"Sweet Water Antibacterial Hand Moisturizer",
						"Ditropan",
						"healthy accents nighttime",
						"MBM 4 Kidney",
						"Erythromycin",
						"Rhizopus oryzae",
						"Inspra",
						"Viral Infection",
						"ESIKA",
						"Infla",
						"ESIKA HYDRACOLOR 2 IN 1 HIGHLY MOISTURIZING AND COLORING SPF 25",
						"Simvastatin",
						"Zostrix Diabetic Joint and Arthritis Pain Relief",
						"Sertraline Hydrochloride",
						"SohMed Pain Relief PM",
						"SHOPKO DRY EYE RELIEF",
						"Felodipine",
						"Lidocaine Hydrochloride and Epinephrine",
						"PERIOSCIENCES SENSITIVE AO Pro",
						"Warfarin Sodium",
						"Paroxetine Hydrochloride",
						"Nite Time",
						"Pacific",
						"ATORVASTATIN CALCIUM",
						"Topical 60 Sec Sodium Fluoride",
						"LBEL HYDRATESS",
						"BETTER THAN NATURE EMULSION",
						"Non-Drowsy Wal-Phed PE Triple Relief",
						"Neomycin and Polymyxin B Sulfates, and Bacitracin Zinc",
						"Avon Sun",
						"Fresh Protect Skin Sanitizer",
						"Preferred Plus Pharmacy 3 percent Hydrogen Peroxide Wipes",
						"Rich Almond Perfecting Makeup Broad Spectrum SPF 25",
						"Pollens - Trees, Cypress, Arizona Cupressus arizonica",
						"Amlodipine and Benazepril Hydrochloride",
						"RESILIENCE LIFT",
						"Evtox",
						"Bone Injuries",
						"Rite Aid",
						"Kali Carbonicum Kit Refill",
						"Handy Solutions Rubbing Alcohol",
						"sunmark pain reliever",
						"preferred plus nicotine",
						"Mentholatum for Kids",
						"Oxygen",
						"Oxygen",
						"Multitrace -4 Pediatric",
						"Ondansetron",
						"Brevital Sodium",
						"Stool Softener and Stimulant Laxative",
						"Fulton Street Market Cetirizine Hydrochloride",
						"Buspirone HCl",
						"Ibuprofen",
						"Cefprozil",
						"Methylprednisolone",
						"Giorgio Armani Designer Lift Smoothing Firming Foundation Broad Spectrum SPF 20 Sunscreen",
						"Sheer Cover Mineral Foundation",
						"Clotrimazole",
						"CVS Athletes Foot Cream .5oz",
						"Olanzapine",
						"Metoclopramide",
						"Diphenoxylate Hydrochloride and Atropine Sulfate",
						"Sheep Sorrel",
						"Genlabs Strike Bac Antibacterial Handsoap",
						"Selsun Blue Itchy Dry Scalp",
						"Levetiracetam",
						"Morphine sulfate",
						"PECGEN PSE Cough Suppressant Expectorant Nasal Decongestant GRAPE Flavor",
						"Cardene IV",
						"Cefdinir",
						"Badger Zinc Oxide Diaper Cream",
						"DaunoXome",
						"Freshmint Anticavity Flouride Toothpaste",
						"leader nicotine",
						"Acremonium strictum",
						"Cabergoline",
						"Proformance Antibacterial",
						"ANTIBACTERIAL HAND SANITIZER",
						"Simvastatin",
						"Good Neighbor Pharmacy",
						"Ofloxacin",
						"Ampicillin and Sulbactam",
						"Rabbitbush Pollen",
						"Wheat Smut",
						"TETANUS TOXOID ADSORBED",
						"Renagel",
						"Exuviance CoverBlend Concealing Treatment Makeup",
						"SULPHUR",
						"Pollens - Weeds, Careless/Pigweed Mix",
						"Doribax",
						"NovoLog Mix 70/30",
						"Flarex",
						"Sun Shades Lip Balm",
						"Sprayology Diet Power",
						"Red Oak",
						"Gabapentin",
						"Antibacterial",
						"amoxicillin and clavulanate potassium",
						"Risperidone",
						"Covergirl Queen Collection All Day Flawless 3in1 Foundation",
						"Soft Care Hand Sanitizer", "Cefuroxime Axetil",
						"Unithroid", "smart sense 3 day treatment", "Aleve",
						"Amoxicillin", "Ondansetron Hydrochloride",
						"Lisinopril",
						"HYDROCODONE BITARTRATE AND ACETAMINOPHEN",
						"Ciprofloxacin Hydrochloride",
						"Oxycodone Hydrochloride",
						"Purell Sanitizing Hand Wipes",
						"Hydrocortisone Valerate", "VICODIN",
						"DOPamine Hydrochloride and Dextrose", "Lisinopril",
						"Diltiazem Hydrochloride",
						"EB301CT BRUISE PAIN RELIEF",
						"Promethazine with Codeine", "UV Capture Sun Pact",
						"ENGLISH WALNUT FOOD", "Alka Seltzer",
						"HAND SANITIZER", "OralLine", "Imiquimod", "AZACTAM",
						"Rivastigmine Tartrate", "Ofloxacin",
						"Pepper Tree Pollen", "Periogel", "Johnson Grass",
						"CD Hydra Life Pro-Youth Protective Fluid", "ALLI",
						"good neighbor pharmacy allergy", "Arnica e rad. 30",
						"CHILDRENS DIMETAPP MULTISYMPTOM COLD AND FLU",
						"IBUPROFEN", "Neutrogena TGel Therapeutic",
						"MISA CHO BO YANG BB", "Chronagesic",
						"Atorvastatin Calcium", "Topiramate",
						"Childrens Cetirizine Hydrochloride Hives Relief",
						"TREE OF HEAVEN POLLEN" }));
		comboBox.setBounds(77, 44, 308, 20);
		contentPane.add(comboBox);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			btn_Click(e);
		}
	}

	protected void btn_Click(ActionEvent e) {
		lista= new Action().consultar(comboBox.getSelectedItem().toString());
		// Se muestran los resultados en el control JTable
		ListarEnGrilla();
	}

	private void ListarEnGrilla() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector().clear();
		for(Bean bean: lista){
			Object row[]= {bean.getDecripcion(),
					bean.getPrecio(),
					bean .getStock(),
					bean.getNombremarca(),
					};
			model .addRow(row);
		}
	}
}
