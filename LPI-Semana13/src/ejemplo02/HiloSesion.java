package ejemplo02;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class HiloSesion extends Thread {

	private JTextField txtTiempo;
	private JLabel lblTiempo, lblmensaje;

	public HiloSesion(JTextField txtTiempo, JLabel lblTiempo, JLabel lblmensaje) {
		this.txtTiempo = txtTiempo;
		this.lblTiempo = lblTiempo;
		this.lblmensaje = lblmensaje;
	}

	@Override
	public void run() {
		try {
			int c = Integer.parseInt(txtTiempo.getText());
			while (true) {
				lblTiempo.setText("" + c);
				c--;
				sleep(1000);
				if (c == 0) {
					lblTiempo.setText("0");
					lblmensaje.setText("!El examen termino!");
					sleep(1000);
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
