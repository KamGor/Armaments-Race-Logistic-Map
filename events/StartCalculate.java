package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bussineslogic.BussinesLogic;

public class StartCalculate implements ActionListener {
	private BussinesLogic bs;
	
	public StartCalculate(BussinesLogic bs) {
		this.bs = bs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bs.startCalculations();
	}
	
}
