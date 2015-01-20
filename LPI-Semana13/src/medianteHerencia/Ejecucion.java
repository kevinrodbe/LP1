package medianteHerencia;

public class Ejecucion {

	
	public static void main(String[] args) {
		Hilo h1 = new Hilo(1000, "Hilo Rapido");
		Hilo h2 = new Hilo(3000, "Hilo Lento");
		h1.start();
		h2.start();
	}

}
