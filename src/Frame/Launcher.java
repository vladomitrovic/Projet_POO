package Frame;

import java.awt.*;
import javax.swing.*;

public class Launcher extends JFrame {

	private JButton btnContacts = new JButton("Contacts");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnAutres = new JButton("Autres...");
	private JPanel panel = new JPanel();
	private JLabel lblNewLabel = new JLabel();
	private ImageIcon wallpaper = new ImageIcon("C:/Users/Aleksandar/Desktop/desktop.jpg");

	public Launcher() {
		
		//Préferences de la frame principale
		setPreferredSize(new Dimension(480, 800));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		//Ajout label et wallpaper
		lblNewLabel.setIcon(wallpaper);
		lblNewLabel.setBounds(0, 0, 474, 765);
		getContentPane().add(lblNewLabel);

		//ajout des boutons à la frame
		btnContacts.setBounds(138, 182, 179, 54);
		getContentPane().add(btnContacts);
		btnGalerie.setBounds(138, 326, 179, 54);
		getContentPane().add(btnGalerie);
		btnAutres.setBounds(141, 459, 176, 55);
		getContentPane().add(btnAutres);

		pack();



	}

}
