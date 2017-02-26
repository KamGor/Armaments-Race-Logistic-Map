package main;

import bussineslogic.BussinesLogic;
import bussineslogic.Country;
import jframes.MainWindow;

public class Main {

	public static void main(String[] args) {
		new MainWindow("Armaments Race", 1024, 728, new BussinesLogic(new Country(0.5, 0.5, false), new Country(0.5, 0.5, false)));
		System.out.println(Double.MIN_VALUE);
	}
}
