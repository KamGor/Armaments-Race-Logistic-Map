package bussineslogic;

import java.awt.BasicStroke;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CalculationThread implements Runnable {

	private Country firstCountry;
	private Country secondCountry;
	private int waitTime;
	private Thread thread;
	private double maxIterations;
	private boolean breakCalculations;
	private ChartPanel chartPanel;
	
	public CalculationThread(Country firstCountry, Country secondCountry, double maxIterations, ChartPanel chartPanel) {
		this.firstCountry = firstCountry;
		this.secondCountry = secondCountry;
		this.maxIterations = maxIterations;
		this.waitTime = 10;
		this.chartPanel = chartPanel;
		
		System.out.println("Ca Wzrost: " + this.firstCountry.getGrowth());
		System.out.println("Cb Wzrost: " + this.secondCountry.getGrowth());
		System.out.println("Ca Potencja³ startowy: " + this.firstCountry.getStartPotential());
		System.out.println("Cb Potencja³ startowy: " + this.secondCountry.getStartPotential());
	}
	
	public void stop() {
		this.breakCalculations = true;
	}
	
	@Override
	public void run() {
		if(this.maxIterations != Double.POSITIVE_INFINITY) {
			for (int x = 0; x < (int)this.maxIterations; x++) {
				if(this.breakCalculations) break;
				this.calculate();
			}
		} else {
			for(;;) {
				if(this.breakCalculations) break;
				this.calculate();
			}
		}
		XYSeries firstCountrySeries = new XYSeries("Country A");
		for(int x = 0; x < this.firstCountry.getAllPotential().size(); x++) {
			firstCountrySeries.add(x, this.firstCountry.getAllPotential().get(x));
		}
		XYSeries secondCountrySeries = new XYSeries("Country B");
		for(int x = 0; x < this.secondCountry.getAllPotential().size(); x++) {
			secondCountrySeries.add(x, this.secondCountry.getAllPotential().get(x));
		}
		XYSeriesCollection temporaryDataset = new XYSeriesCollection();
		temporaryDataset.addSeries(firstCountrySeries);
		temporaryDataset.addSeries(secondCountrySeries);
		JFreeChart temporaryChart = ChartFactory.createXYLineChart("Armaments Race", "Iterations", "Investment level", temporaryDataset);
		XYPlot plot = temporaryChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		this.chartPanel.setChart(temporaryChart);
	}
	
	public void start() {
		this.breakCalculations = false;
		if(thread == null) {
			thread = new Thread(this);
			if(this.maxIterations != Double.POSITIVE_INFINITY) {
				try {
					thread.start();
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.firstCountry.getAllPotential());
			} else {
				thread.start();
			}
			
		}
	}
	
	private void calculate() {
		//System.out.println(".");
		this.firstCountry.calcPotential();
		this.secondCountry.calcPotential();
		try {
			Thread.sleep(this.waitTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
