package listas;

import java.util.ArrayList;
import java.util.Collections;

public class Lista {

	public static void main(String[] args) {
		Auto a1 = new Auto(1, "Yaris", "Toyota", 13.000);
		Auto a2 = new Auto(2, "Tico", "Daewo", 5.000);
		Auto a3 = new Auto(3, "Murano", "Nissan", 35.000);
		Auto a4 = new Auto(4, "Corolla", "Toyota", 27.000);
		Auto a5 = new Auto(5, "Ferrari-8", "Ferrari", 80.000);
	
		ArrayList<Auto> lista = new ArrayList<Auto>();
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		lista.add(a4);
		lista.add(a5);
		
		System.out.println(lista);
		
		Lista l = new Lista();

		//Ordenamos por modelo
		Collections.sort(lista);
		Collections.reverse(lista);

		//Ordenaminto por atributo - por Precio
		Collections.sort(lista, new SortPrecio());
		
		//Ordenaminto por atributo - por Marca
		Collections.sort(lista, new SortMarca());
		
		
		l.listar(lista);
	}

	
	public void listar(ArrayList<Auto> lista){
		for (Auto a : lista) {
			System.out.println(a.getId()+"\t"+  
							   a.getModelo()+"\t"+
							   a.getMarca()+"\t"+
							   a.getPrecio());
		}
		System.out.println();
	}
	
	
}
