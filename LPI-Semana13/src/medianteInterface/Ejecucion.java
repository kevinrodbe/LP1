package medianteInterface;

public class Ejecucion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Pimero crea el cuerpo del hilo
		CuerpoHilo c1 = new CuerpoHilo(1000, "Hilo Rapido");
		CuerpoHilo c2 = new CuerpoHilo(3000, "Hilo Lento");
		
		//Creas los hilo y le agregas los cuerpos
		Thread hilo1 = new Thread(c1);
		Thread hilo2 = new Thread(c2);
		
		//Inicias los hilos
		hilo1.start();
		hilo2.start();
	}

}
