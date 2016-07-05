package cage.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cage.core.Kass;

/**
 * @author K Listener for renaming a cat.
 *
 */
public class RenamingListener implements ActionListener {

	private Kass kass;

	public RenamingListener(Kass k) {
		this.kass = k;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//nimetamiskonteiner tüüpi aken kus event toimus
		RenamingContainer aken = (RenamingContainer)((Component)e.getSource()).getParent().getParent().getParent().getParent();

		//muudame nime ära selleks mis on kastis
		kass.setNimi(aken.lahter.getText());
		CAGEFrame.getKassilist().repaint();
		aken.dispose();
	}
}