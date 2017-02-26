package events;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bussineslogic.BussinesLogic;

public class ValueChangeIterations implements ChangeListener {
	private BussinesLogic bs;
	
	public ValueChangeIterations(BussinesLogic bs) {
		this.bs = bs;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if(source.getValue() == source.getMaximum()) {
			bs.setMaxIterations(Double.POSITIVE_INFINITY);
		} else {
			bs.setMaxIterations(source.getValue());
		}
	}
}
