package generics00;

import java.util.ArrayList;

public class Ejecucion {

	
	
	public static void main(String[] args) {
		{
			HelloOrdinario h = new HelloOrdinario("Elba");
			System.out.println(h);
		}
		{
			HelloGenerico<String> h = new HelloGenerico<String>("Elba");
			System.out.println(h);
		}	 
		{
			HelloGenerico<Double> h = new HelloGenerico<Double>(15.5);
			System.out.println(h);
		}
		{
			HelloDosParametros<Double, String> h = 
					new HelloDosParametros<Double, String>(15.5,"Elba");
			System.out.println(h);
		}
		
		
	}

}
