package medianteHerencia;

/*
 * 1)Para que sea un hilo debe heredar de Thread
 * 2)Thread esta en el paquete java.lang
 * 3)java.lang se importa por defecto
 */

public class Hilo extends Thread{
	
	private long tiempoDescanso;
	private String nombre;
	
	public Hilo(long tiempoDescanso, String nombre){
		this.tiempoDescanso = tiempoDescanso;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(nombre);
		
			try {
				sleep(tiempoDescanso);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
