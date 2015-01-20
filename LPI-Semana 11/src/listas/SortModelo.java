package listas;

import java.util.Comparator;

public class SortModelo implements Comparator<Auto> {

	@Override
	public int compare(Auto o1, Auto o2) {
		return o1.getModelo().compareTo(o2.getModelo());
	}

}