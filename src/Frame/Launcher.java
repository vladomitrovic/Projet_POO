package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Galerie.Photo;

public class Launcher extends JFrame {
//	private ArrayList<JPanel>slider = new ArrayList<JPanel>();
	private JButton btnContacts = new JButton("Contacts");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnAutres = new JButton("Autres...");
	private JLabel lblNewLabel = new JLabel();
	private ImageIcon wallpaper = new ImageIcon("Pictures/desktop.jpg");
	private JPanel panelLauncher = new JPanel();
	private JPanel west = new JPanel();
	private JPanel est = new JPanel();
	private JPanel south = new JPanel();
	private TopBarPanel2 topBar = new TopBarPanel2();
	private Photo home = new Photo("Pictures/home.png");
	private JButton homeButton = new JButton(home);
	private FlowLayout flSouth = new FlowLayout();
	private MainPanelGalerie galerie = new MainPanelGalerie(panelLauncher) ;
	private MainPanelCarnet carnet = new MainPanelCarnet(panelLauncher) ;

	public Launcher() {

		// Préferences de la frame principale
		setUndecorated(false);
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
		btnContacts.addActionListener(new Contact_Click());

		// ajout des boutons à la frame
		btnContacts.setBounds(138, 182, 179, 54);
		panelLauncher.add(btnContacts);
		btnGalerie.setBounds(138, 326, 179, 54);
		panelLauncher.add(btnGalerie);
		btnAutres.setBounds(141, 459, 176, 55);
		panelLauncher.add(btnAutres);
		
		//ajout des panels dans mon arraylist


		// ajout du label à la frame
		panelLauncher.add(lblNewLabel);
		west.setPreferredSize(new Dimension(25, 100));
		est.setPreferredSize(new Dimension(25, 100));
		west.setBackground(Color.BLACK);
		est.setBackground(Color.BLACK);
		south.setBackground(Color.BLACK);
		flSouth.setAlignment(flSouth.CENTER);
		flSouth.setVgap(10);
		south.setLayout(flSouth);
		homeButton.setPreferredSize(new Dimension(24, 24));
		homeButton.setBorderPainted(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setFocusPainted(false);
		homeButton.setOpaque(false);
		homeButton.addActionListener(new Home_Click());
		south.add(homeButton);
		add(topBar, BorderLayout.NORTH);
		add(est, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(panelLauncher, BorderLayout.CENTER);

		pack();

	}

	public JPanel getPanelLauncher() {
		return panelLauncher;
	}
	
	class Home_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			panelLauncher.setVisible(true);
		}
		
	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-+generated method stub
			panelLauncher.setVisible(false);
			Launcher.this.add(galerie);
		}

	}

	class Contact_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			panelLauncher.setVisible(false);
			Launcher.this.add(carnet);

		}

	}
}
