package jpanels;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
public class MainChartPanel extends ChartPanel {
	private static JFreeChart mainChart;
	public MainChartPanel() {
		super(mainChart = ChartFactory.createXYLineChart("Armaments Race", "Iterations", "Investment level", new XYSeriesCollection()));
	}
	
	public JFreeChart newGetChart() {
		return MainChartPanel.mainChart;
	}
	
	public void newSetChart(JFreeChart chart) {
		MainChartPanel.mainChart = chart;
	}
}
