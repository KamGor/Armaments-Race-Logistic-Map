package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import jframes.MainWindow;

public class CloseApplication implements ActionListener {
	
	private MainWindow mainWindow;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object[] options = {
				"Yes",
                "No"
		};
		int n = JOptionPane.showOptionDialog(mainWindow,
		"Are You sure?",
		"Exit",
		JOptionPane.YES_NO_CANCEL_OPTION,
		JOptionPane.QUESTION_MESSAGE,
		null,
		options,
		options[1]);
		System.out.println(n);
		if(n==0) System.exit(0);
	}
	
}