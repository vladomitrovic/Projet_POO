package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher extends JFrame {

	private JButton btnContacts = new JButton("Contacts");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnAutres = new JButton("Autres...");
	private JLabel lblNewLabel = new JLabel();
	private ImageIcon wallpaper = new ImageIcon("Pictures/desktop.jpg");
	private JPanel panelLauncher = new JPanel();

	public Launcher() {

		// Préferences de la frame principale
		setPreferredSize(new Dimension(480, 800));
		setSize(480, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Préference du Panel
		panelLauncher.setLayout(null);

		// Modification du label et ajout du wallpaper
		lblNewLabel.setIcon(wallpaper);
		lblNewLabel.setBounds(0, 0, 474, 765);

		// ajout des actionlistener sur les boutons
		btnGalerie.addActionListener(new Galerie_Click());


		// ajout des boutons à la frame
		btnContacts.setBounds(138, 182, 179, 54);
		panelLauncher.add(btnContacts);
		btnGalerie.setBounds(138, 326, 179, 54);
		panelLauncher.add(btnGalerie);
		btnAutres.setBounds(141, 459, 176, 55);
		panelLauncher.add(btnAutres);

		// ajout du label à la frame
		panelLauncher.add(lblNewLabel);
		add(panelLauncher);

		pack();

	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			panelLauncher.setVisible(false);
			Launcher.this.add(new MainPanelGalerie(panelLauncher));

		}

	}



}

