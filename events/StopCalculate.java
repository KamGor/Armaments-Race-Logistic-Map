package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bussineslogic.BussinesLogic;

public class StopCalculate implements ActionListener {
	private BussinesLogic bs;
	
	public StopCalculate(BussinesLogic bs) {
		this.bs = bs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bs.stopCalcilations();
		//System.out.println(bs.getFirstCountry().getAllPotential());
		//System.out.println(bs.getSecondCountry().getAllPotential());
	}
	
}
