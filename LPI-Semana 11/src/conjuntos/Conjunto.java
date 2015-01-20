package conjuntos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class Conjunto {

	public static void main(String[] args) {
		{
			List<String> c = new ArrayList<String>();
			c.add("Sheyla");
			c.add("Elba");
			c.add("Diana");
			c.add("Elba");

			System.out.println(c);
		}
		//En los SET no se permite repetidos
		{
			//Ordenamiento por hash
			Set<String> c = new HashSet<String>();
			c.add("Sheyla");
			c.add("Elba");
			c.add("Diana");
			c.add("Elba");

			System.out.println(c);
		}
		{
			//Ordenamiento por comparetor o omparable
			//que internamente esta definido en la clase String
			Set<String> c = new TreeSet<String>();
			c.add("Sheyla");
			c.add("Elba");
			c.add("Diana");
			c.add("Elba");

			System.out.println(c);
		}
		{
			//-Es doblemente enlazado
			//-Tiene el orden de ingreso
			Set<String> c = new LinkedHashSet<String>();
			c.add("Sheyla");
			c.add("Elba");
			c.add("Diana");
			c.add("Elba");

			System.out.println(c);
		}		
		
		{
			
			//Se ordena en base al comparetor
			Set<Auto> c = new TreeSet<Auto>();
			c.add(new Auto(1, "Yaris", "Toyota", 13.000));
			c.add(new Auto(2, "Tico", "Daewo", 5.000));
			c.add(new Auto(3, "Murano", "Nissan", 35.000));
			c.add(new Auto(4, "Corolla", "Toyota", 27.000));
			c.add(new Auto(5, "Ferrari-8", "Ferrari", 80.000));
			c.add(new Auto(1, "Yaris", "Toyota", 13.000));
			
			for (Auto a : c) {
				System.out.println(a.getId() + " - " +
								   a.getModelo() + " - " +
								   a.getMarca() + " - " +
								   a.getPrecio());
			}
			
			//Imprime todos los metodos toString de los objetos Auto
			System.out.println(c);
			
		}
		
		{	
			//Se ordena en base al equals y hashcod
			Set<Auto> c = new HashSet<Auto>();
			c.add(new Auto(1, "Yaris", "Toyota", 13.000));
			c.add(new Auto(2, "Tico", "Daewo", 5.000));
			c.add(new Auto(3, "Murano", "Nissan", 35.000));
			c.add(new Auto(4, "Corolla", "Toyota", 27.000));
			c.add(new Auto(5, "Ferrari-8", "Ferrari", 80.000));
			c.add(new Auto(1, "Yaris", "Toyota", 13.000));
			
			for (Auto a : c) {
				System.out.println(a.getId() + " - " +
								   a.getModelo() + " - " +
								   a.getMarca() + " - " +
								   a.getPrecio());
			}
			
			//Imprime todos los metodos toString de los objetos Auto
			System.out.println(c);
			
		}
		
	}

}
