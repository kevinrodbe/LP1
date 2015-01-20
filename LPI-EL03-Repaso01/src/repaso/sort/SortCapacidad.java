package repaso.sort;

import java.util.Comparator;

import repaso.bean.EventoBean;

public class SortCapacidad implements Comparator<EventoBean> {

	@Override
	public int compare(EventoBean arg0, EventoBean arg1) {
		if(arg0.getCapacidad() > arg1.getCapacidad())
			return 1;
		else if (arg0.getCapacidad() == arg1.getCapacidad())
			return 0;
		else 
			return -1;
	}
}