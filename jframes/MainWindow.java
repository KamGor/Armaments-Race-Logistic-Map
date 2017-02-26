package jframes;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import bussineslogic.BussinesLogic;
import jmenubars.MainBar;
import jpanels.MainChartPanel;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private BussinesLogic bs;
	
	public MainWindow(String title, int width, int height, BussinesLogic bs) {
		this.bs = bs;
		MainChartPanel chartPanel = new MainChartPanel();
		this.add(chartPanel);
		ToolWindow toolwindow = new ToolWindow(height, this.bs, chartPanel);
		this.setJMenuBar(new MainBar(toolwindow));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(title);
		this.setVisible(true);
		this.setSize(width, height);
		this.setResizable(false);
		this.addComponentListener(new FrameMovement(toolwindow));
		this.addFocusListener(new FrameFocused(toolwindow));
		toolwindow.setLocation(this.getX()+this.getWidth()+10, this.getY());
		this.setLocationRelativeTo(null);
	}
	
	private class FrameMovement extends ComponentAdapter {
		ToolWindow toolWindow;
		
		public FrameMovement (ToolWindow toolWindow) {
			this.toolWindow = toolWindow;
		}
		
		public void componentMoved(ComponentEvent e) {
			MainWindow mainWindow = (MainWindow)e.getSource();
			toolWindow.setLocation(mainWindow.getX()+mainWindow.getWidth()+10, mainWindow.getY());
			toolWindow.toFront();
			mainWindow.toFront();
		}
	}
	
	private class FrameFocused implements FocusListener {
		private ToolWindow toolWindow;
		
		public FrameFocused(ToolWindow toolWindow) {
			this.toolWindow = toolWindow;
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			toolWindow.toFront();
		}

		@Override
		public void focusLost(FocusEvent e) {
			
		}
		
	}
	
}
