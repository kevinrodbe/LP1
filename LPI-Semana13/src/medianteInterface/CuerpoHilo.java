package medianteInterface;

public class CuerpoHilo implements Runnable{

	private long tiempoDescanso;
	private String nombre;
	
	public CuerpoHilo(long tiempoDescanso, String nombre){
		this.tiempoDescanso = tiempoDescanso;
		this.nombre = nombre;
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(nombre);
		
			try {
				Thread.sleep(tiempoDescanso);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
