package events;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bussineslogic.Country;

public class ValueChangeGrowth implements ChangeListener {
	private Country country;
	
	public ValueChangeGrowth(Country country) {
		this.country = country;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		country.setGrowth(source.getValue()/100f);
	}
	
}