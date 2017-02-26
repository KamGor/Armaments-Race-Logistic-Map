package events;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenWebsite implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evt) {
		try {
			Desktop.getDesktop().browse(new URI("http://www.epidemicstudio.pl/"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}