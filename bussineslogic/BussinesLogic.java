package bussineslogic;

import org.jfree.chart.ChartPanel;

public class BussinesLogic {
	
	private Country firstCountry;
	private Country secondCountry;
	private double maxIterations;
	private CalculationThread t1;
	private ChartPanel chartPanel;
	
	public BussinesLogic(Country firstCountry, Country secondCountry) {
		this.firstCountry = firstCountry;
		this.secondCountry = secondCountry;
		this.firstCountry.setRival(this.secondCountry);
		this.secondCountry.setRival(this.firstCountry);
	}
	
	public Country getFirstCountry() {
		return this.firstCountry;
	}
	
	public Country getSecondCountry() {
		return this.secondCountry;
	}
	
	public void setMaxIterations(double maxIterations) {
		this.maxIterations = maxIterations;
	}
	
	public double getMaxIterations() {
		return this.maxIterations;
	}
	
	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}
	
	public void resetCalculations() {
		this.firstCountry = new Country(this.firstCountry.getStartPotential(), this.firstCountry.getGrowth(), false);
		this.secondCountry = new Country(this.secondCountry.getStartPotential(), this.secondCountry.getGrowth(), false);
	}
	
	public void startCalculations() {
		this.firstCountry.resetPotentialList();
		this.secondCountry.resetPotentialList();
		this.t1 = new CalculationThread(this.firstCountry, this.secondCountry, this.maxIterations, this.chartPanel);
		this.t1.start();
	}
	
	public void stopCalcilations() {
		if(t1 != null) {
			this.t1.stop();
		} else {
			this.t1 = null;
		}
	}
}
