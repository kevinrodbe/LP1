package listas;

import java.util.Comparator;

public class SortMarca implements Comparator<Auto> {

	@Override
	public int compare(Auto o1, Auto o2) {
		return o1.getMarca().compareTo(o2.getMarca());
	}

}