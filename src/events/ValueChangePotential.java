package events;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bussineslogic.Country;

public class ValueChangePotential implements ChangeListener {
	private Country country;
	
	public ValueChangePotential(Country country) {
		this.country = country;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		country.setFirstPotential(source.getValue()/100f);
	}
	
}