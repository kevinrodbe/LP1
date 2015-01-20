package ejemplo01;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Formulario extends JFrame {

	public JButton btnPrueba = new JButton("Prueba");

	public Formulario() {
		setLayout(new FlowLayout());
		btnPrueba.setFont(new Font("Arial", Font.BOLD, 35));
		add(btnPrueba);
		btnPrueba.setBorder(new LineBorder(new java.awt.Color(0, 255, 0), 1,
				false));
		btnPrueba.setBackground(new java.awt.Color(255, 255, 255));
		btnPrueba.setForeground(new java.awt.Color(0, 255, 0));
		btnPrueba.setText(" ");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(0, 0, 0));
		setSize(500, 220);
	}

	public static void main(String[] args) {
		
		Formulario frm = new Formulario();
		
		HiloBoton h1 = new HiloBoton(frm.btnPrueba);
		h1.start();
	
	}

}
