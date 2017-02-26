package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import bussineslogic.Country;

public class ChangeNoise implements ActionListener {
	private Country country;
	
	public ChangeNoise(Country country) {
		this.country = country;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox source = (JCheckBox)e.getSource();
		this.country.setNoise(source.isSelected());
	}
}
