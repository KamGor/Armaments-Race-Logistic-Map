package jframes;

import java.awt.GridLayout;
import java.util.Hashtable;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import bussineslogic.BussinesLogic;
import events.ChangeNoise;
import events.StartCalculate;
import events.StopCalculate;
import events.ValueChangeGrowth;
import events.ValueChangeIterations;
import events.ValueChangePotential;
import jpanels.MainChartPanel;

@SuppressWarnings("serial")
public class ToolWindow extends JFrame {
	private BussinesLogic bs;
	private MainChartPanel chartPanel;
	
	public ToolWindow(int height, BussinesLogic bs, MainChartPanel chartPanel) {
		this.bs = bs;
		this.bs.setMaxIterations(100);
		this.chartPanel = chartPanel;
		this.bs.setChartPanel(this.chartPanel);
		
		JPanel mainPanel = new JPanel(new GridLayout(2,0));
		
		JPanel toolsPanel = new JPanel();
		toolsPanel.setLayout(new BoxLayout(toolsPanel, BoxLayout.PAGE_AXIS));
		JButton calculate = new JButton("Calculate");
		calculate.setAlignmentX(CENTER_ALIGNMENT);
		calculate.addActionListener(new StartCalculate(this.bs));
		toolsPanel.add(calculate);
		JButton stopCalculating = new JButton("Stop calculating");
		stopCalculating.setAlignmentX(CENTER_ALIGNMENT);
		stopCalculating.addActionListener(new StopCalculate(this.bs));
		toolsPanel.add(stopCalculating);
		JButton resetCalculations = new JButton("Reset calculations");
		resetCalculations.setAlignmentX(CENTER_ALIGNMENT);
		toolsPanel.add(resetCalculations);
		JButton resetCountries = new JButton("Reset countries");
		resetCountries.setAlignmentX(CENTER_ALIGNMENT);
		toolsPanel.add(resetCountries);
		toolsPanel.add(new JLabel("Iterations"));
		JSlider maxIterationSlider = new JSlider(1, 500);
		Hashtable<Integer, JLabel> iterationLabelTable = new Hashtable<Integer, JLabel>();
		iterationLabelTable.put(new Integer(maxIterationSlider.getMinimum()), new JLabel(maxIterationSlider.getMinimum() + ""));
		iterationLabelTable.put(new Integer(maxIterationSlider.getMaximum()), new JLabel("Infinity"));
		iterationLabelTable.put(new Integer(maxIterationSlider.getMinimum()/2), new JLabel(maxIterationSlider.getMaximum()/2 + ""));
		maxIterationSlider.setLabelTable(iterationLabelTable);
		maxIterationSlider.setPaintLabels(true);
		maxIterationSlider.addChangeListener(new ValueChangeIterations(this.bs));
		toolsPanel.add(maxIterationSlider);
		
		toolsPanel.setBorder(BorderFactory.createTitledBorder("Tools"));
		
		Hashtable<Integer, JLabel> potentialLabelTable = new Hashtable<Integer, JLabel>();
		potentialLabelTable.put(new Integer(0), new JLabel("0"));
		potentialLabelTable.put(new Integer(100), new JLabel("1"));
		potentialLabelTable.put(new Integer(50), new JLabel("0.5"));
		
		Hashtable<Integer, JLabel> incLabelTable = new Hashtable<Integer, JLabel>();
		incLabelTable.put(new Integer(0), new JLabel("0"));
		incLabelTable.put(new Integer(100), new JLabel("1"));
		incLabelTable.put(new Integer(50), new JLabel("0.5"));
		
		JPanel firstCountryPage = new JPanel();
		firstCountryPage.setLayout(new BoxLayout(firstCountryPage, BoxLayout.PAGE_AXIS));
		
		firstCountryPage.add(new JLabel("Starting potential"));
		JSlider firstCountryPotentialSlider = new JSlider();
		firstCountryPotentialSlider.setLabelTable(potentialLabelTable);
		firstCountryPotentialSlider.setPaintLabels(true);
		firstCountryPotentialSlider.addChangeListener(new ValueChangePotential(bs.getFirstCountry()));
		firstCountryPage.add(firstCountryPotentialSlider);
		
		firstCountryPage.add(new JLabel("Increasement"));
		JSlider firstCountryIncresementSlider = new JSlider();
		firstCountryIncresementSlider.setLabelTable(incLabelTable);
		firstCountryIncresementSlider.setPaintLabels(true);
		firstCountryIncresementSlider.addChangeListener(new ValueChangeGrowth(bs.getFirstCountry()));
		firstCountryPage.add(firstCountryIncresementSlider);
		
		JCheckBox noiseCheckBox = new JCheckBox("Noise");
		noiseCheckBox.setAlignmentX(CENTER_ALIGNMENT);
		noiseCheckBox.addActionListener(new ChangeNoise(this.bs.getFirstCountry()));
		firstCountryPage.add(noiseCheckBox);
		
		JPanel secondCountryPage = new JPanel();
		secondCountryPage.setLayout(new BoxLayout(secondCountryPage, BoxLayout.PAGE_AXIS));
		
		secondCountryPage.add(new JLabel("Starting potential"));
		JSlider secondCountryPotentialSlider = new JSlider();
		secondCountryPotentialSlider.setLabelTable(potentialLabelTable);
		secondCountryPotentialSlider.setPaintLabels(true);
		secondCountryPotentialSlider.addChangeListener(new ValueChangePotential(bs.getSecondCountry()));
		secondCountryPage.add(secondCountryPotentialSlider);
		
		secondCountryPage.add(new JLabel("Increasement"));
		JSlider secondCountryIncresementSlider = new JSlider();
		secondCountryIncresementSlider.setLabelTable(incLabelTable);
		secondCountryIncresementSlider.setPaintLabels(true);
		secondCountryIncresementSlider.addChangeListener(new ValueChangeGrowth(bs.getSecondCountry()));
		secondCountryPage.add(secondCountryIncresementSlider);
		
		noiseCheckBox = new JCheckBox("Noise");
		noiseCheckBox.setAlignmentX(CENTER_ALIGNMENT);
		noiseCheckBox.addActionListener(new ChangeNoise(this.bs.getSecondCountry()));
		secondCountryPage.add(noiseCheckBox);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Country A", firstCountryPage);
		tabbedPane.addTab("Country B", secondCountryPage);
		
		mainPanel.add(toolsPanel);
		mainPanel.add(tabbedPane);
		
		this.add(mainPanel);
		
		this.setFocusableWindowState(false);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setSize(300, height);
	}
	
}
