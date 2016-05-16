package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher extends BasiqueFrame {

	private JButton btnContacts = new JButton("Contacts");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnAutres = new JButton("Autres...");
	private JLabel lblNewLabel = new JLabel();
	private ImageIcon wallpaper = new ImageIcon("Pictures/desktop.jpg");

	public Launcher() {

		// Préferences de la frame principale
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// Modification du label et ajout du wallpaper
		lblNewLabel.setIcon(wallpaper);
		lblNewLabel.setBounds(0, 0, 474, 765);

		// ajout des actionlistener sur les boutons
		btnGalerie.addActionListener(new Galerie_Click());

		// ajout des boutons à la frame
		btnContacts.setBounds(138, 182, 179, 54);
		getContentPane().add(btnContacts);
		btnGalerie.setBounds(138, 326, 179, 54);
		getContentPane().add(btnGalerie);
		btnAutres.setBounds(141, 459, 176, 55);
		getContentPane().add(btnAutres);
		
		//ajout du label à la frame
		getContentPane().add(lblNewLabel);

		pack();

	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setVisible(false);
			MainFrmGalerie frmGalerie = new MainFrmGalerie() ;
			frmGalerie.setVisible(true);

		}

	}

}
