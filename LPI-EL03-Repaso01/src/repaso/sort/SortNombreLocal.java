package repaso.sort;

import java.util.Comparator;

import repaso.bean.EventoBean;

public class SortNombreLocal implements Comparator<EventoBean> {

	@Override
	public int compare(EventoBean arg0, EventoBean arg1) {
		return arg0.getNombreLocal().compareToIgnoreCase(arg1.getNombreLocal());
	}

}
