package jmenubars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import events.CloseApplication;
import events.OpenWebsite;
import jframes.ToolWindow;

@SuppressWarnings("serial")
public class MainBar extends JMenuBar {

	public MainBar(ToolWindow toolWindow) {
		JMenu menu;
		
		menu = new JMenu("File");
		this.add(menu);
		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("New");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Save");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Load");
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new CloseApplication());
		menu.add(menuItem);
		
		menu = new JMenu("Window");
		this.add(menu);
		
		menuItem = new JCheckBoxMenuItem("Tools", true);
		menuItem.addActionListener(new ShowToolWindow(toolWindow));
		menu.add(menuItem);
		
		menu = new JMenu("Help");
		this.add(menu);
		
		menuItem = new JMenuItem("Website");
		menuItem.addActionListener(new OpenWebsite());
		menu.add(menuItem);
		
		menuItem = new JMenuItem("About");
		menu.add(menuItem);
	}
	
	private class ShowToolWindow implements ActionListener {
		
		ToolWindow toolWindow;
		
		public ShowToolWindow(ToolWindow toolWindow) {
			this.toolWindow = toolWindow;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			this.toolWindow.setVisible(!this.toolWindow.isVisible());
		}
		
	}
}
