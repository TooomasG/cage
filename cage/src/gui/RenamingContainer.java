package gui;

import gui.menubar.LocaleChangeListener;
import gui.menubar.Locales;
import gui.menubar.MenuLanguageListener;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Point;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import core.Kass;


/**
 * A frame displayed when renaming a cat.
 * 
 */
@SuppressWarnings("serial")
public class RenamingContainer extends JFrame implements LocaleChangeListener {

	JTextField lahter = new JTextField();
	String kassinimi;
	JLabel silt = new JLabel();
	JButton nupp = new JButton();

	public RenamingContainer(Kass k, Point p) throws HeadlessException {

		// Listing that this component needs to fire whenever there's a locale
		// change
		MenuLanguageListener.addToDeclaredComponents(this);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 90);
		this.setLocation(p);
		this.getContentPane().setLayout(new BorderLayout());
		kassinimi = k.getNimi();
		// setting up things that are already defined in the method
		// onLocaleChange()
		this.onLocaleChange();
		lahter.setText(kassinimi);

		// button
		nupp.setToolTipText(Locales.tipBundle.getString("tt12"));
		nupp.addActionListener(new RenamingListener(k));

		// enter key:
		this.getRootPane().setDefaultButton(nupp);

		this.add(silt, BorderLayout.WEST);
		this.add(lahter, BorderLayout.CENTER);
		this.add(nupp, BorderLayout.SOUTH);

		this.setVisible(true);
	}

	@Override
	public void onLocaleChange() {
		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(Locales.currentLocale);
		Object[] messageArguments = { kassinimi };
		formatter.applyPattern(Locales.mainBundle.getString("title8"));
		this.setTitle(formatter.format(messageArguments));
		silt.setText(Locales.mainBundle.getString("label4"));
		nupp.setText(Locales.mainBundle.getString("button11"));

	}

}
