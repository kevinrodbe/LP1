package propuestos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class Formulario extends JFrame 
			implements ActionListener{
	public JComboBox cboTiempo;
	
	public JLabel lblTiempo;
	private JButton btnEmpezar;

	public Formulario() {
		getContentPane().setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(0, 0, 0));

		cboTiempo = new JComboBox();
		cboTiempo.addItem("Jorge  Arcos");
		cboTiempo.addItem("Maria  Gutarra");
		cboTiempo.addItem("Patricia  Vivas");
		cboTiempo.addItem("Wendy  Camarena");
		cboTiempo.addItem("Milagros  Jacinto");
		cboTiempo.addItem("Pablo  Milanes");
		getContentPane().add(cboTiempo);
		cboTiempo.setBounds(10, 22, 180, 21);

		btnEmpezar = new JButton();
		getContentPane().add(btnEmpezar);
		btnEmpezar.setText("Empezar");
		btnEmpezar.setBounds(246, 22, 86, 21);
		btnEmpezar.addActionListener(this);
		
		lblTiempo = new JLabel();
		getContentPane().add(lblTiempo);
		lblTiempo.setBounds(349, 22, 120, 21);
		lblTiempo.setBorder(new LineBorder(new java.awt.Color(0,255,0), 3, false));
		lblTiempo.setForeground(new java.awt.Color(0,255,0));
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setFont(new java.awt.Font("Tahoma",1,18));

		setSize(500, 220);
	}

	public static void main(String[] args) {
		new Formulario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEmpezar){

			
		}
	}
	
	

}
