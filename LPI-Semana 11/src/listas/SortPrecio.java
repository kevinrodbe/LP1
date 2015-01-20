package listas;

import java.util.Comparator;

public class SortPrecio implements Comparator<Auto> {

	@Override
	public int compare(Auto o1, Auto o2) {
		return o1.getPrecio().compareTo(o2.getPrecio());
	}

}
