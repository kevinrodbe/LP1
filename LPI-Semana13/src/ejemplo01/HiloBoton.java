package ejemplo01;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HiloBoton extends Thread {

	private JButton btn;

	public HiloBoton(JButton btn) {
		this.btn = btn;
	}

	@Override
	public void run() {
		int c = 1;
		while (true) {
			btn.setIcon(new ImageIcon("images/T" + c + ".gif"));
			c++;
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (c > 10) c = 1;
		}

	}
}
