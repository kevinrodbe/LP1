package repaso.sort;

import java.util.Comparator;

import repaso.bean.EventoBean;

public class SortNombreEvento implements Comparator<EventoBean> {

	@Override
	public int compare(EventoBean arg0, EventoBean arg1) {
		return arg0.getNombre()
					.compareToIgnoreCase(arg1.getNombre());
	}

}
