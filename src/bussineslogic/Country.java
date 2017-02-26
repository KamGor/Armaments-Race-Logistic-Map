package bussineslogic;

import java.util.ArrayList;

public class Country {
	
	private ArrayList<Double> potential;
	private double growth;
	private boolean noise;
	private Country Rival;
	
	public Country(double potential, double growth, boolean noise) {
		this.potential = new ArrayList<Double>();
		this.potential.add(potential);
		this.growth = growth;
	}
	
	public void resetPotentialList() {
		double temporary = this.getStartPotential();
		this.potential = new ArrayList<Double>();
		this.setFirstPotential(temporary);
	}
	
	public double getStartPotential() {
		return this.potential.get(0);
	}
	
	public boolean getNoise() {
		return this.noise;
	}
	
	public double getGrowth() {
		return this.growth;
	}
	
	public double getLastPotential() {
		return this.potential.get(this.potential.size()-1);
	}
	
	public ArrayList<Double> getAllPotential() {
		return this.potential;
	}
	
	public void setRival(Country Rival) {
		this.Rival = Rival;
	}
	
	public void setGrowth(double growth) {
		this.growth = growth;
	}
	
	public void setNoise(boolean noise) {
		this.noise = noise;
	}
	
	public void setFirstPotential(double potential) {
		if(this.potential.isEmpty()) {
			this.potential.add(potential);
		} else {
			this.potential.set(0, potential);
		}
	}
	
	public void calcPotential() {
		//System.out.println("Wzrost: " + this.growth);
		//System.out.println("Potencja³ rywala: " + this.Rival.getLastPotential());
		double newPotential = 4 * this.growth * this.Rival.getLastPotential() * (1 - this.Rival.getLastPotential());
		//System.out.println("Nowy potencja³: " + newPotential);
		this.potential.add(newPotential);
	}
	
}
