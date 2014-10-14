package kassid_rt13oop_tg_kal;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



@SuppressWarnings({ "serial"})
public class LoomisKonteiner extends JFrame{
	
	
	static JTextArea fenot = new JTextArea("");
	static String deftekst= "Sisesta siia oma loodava kassi nimi";
	static JTextField kassinimi = new JTextField(deftekst);

	
	public LoomisKonteiner(){
		Container fenojumal= getContentPane();
		fenojumal.setLayout(new BorderLayout());
		Container fenotekst= new Container();
		JPanel loomisasjad= new JPanel();
		
		fenojumal.add(fenotekst, BorderLayout.CENTER);
		fenojumal.add(loomisasjad, BorderLayout.SOUTH);
		
		fenotekst.setLayout(new BorderLayout());
		loomisasjad.setLayout(new GridLayout(2,1));

		fenotekst.add(fenot,BorderLayout.CENTER);
		
		//Loomisasjad
		
		//Fenotüübi kasti kassi nime sisestamise väli	
		loomisasjad.add(kassinimi);
		kassinimi.addFocusListener(new LoominguKuular());
		
		//Fenotüübi kasti "loo kass" nupp
		JButton kassilooming = new JButton("Loo kass");
		loomisasjad.add(kassilooming);
		kassilooming.addActionListener(new LoominguKuular());
		
		
	}
	public static JTextArea getFenot() {
		return fenot;
	}

	// Eriline setter kuularile
	public static void setFenot(String fenot) {
		LoomisKonteiner.fenot.setText(fenot);
	}
	
}


