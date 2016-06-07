package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Elements.ApplicationButton;
import Elements.HomeButton;
import Elements.TopBarPanel;
import Galerie.Photo;

public class Launcher extends JFrame {

	// TopBarPanel
	private TopBarPanel topBar = new TopBarPanel();

	// pour le cadre (sud est west)
	private JPanel west = new JPanel();
	private JPanel est = new JPanel();
	private JPanel south = new JPanel();
	private FlowLayout flSouth = new FlowLayout();
	private HomeButton homeButton = new HomeButton();

	// Panel parent pour cardLayout
	public CardLayout c1 = new CardLayout();
	public JPanel mainContainer = new JPanel();

	// panel pour les applications
	private PanelApplications panelApplication = new PanelApplications();

	// Boutons pour applications
	private ApplicationButton btnContacts = new ApplicationButton(new Photo("PicturesElements/phone-book.png"));
	private ApplicationButton btnGalerie = new ApplicationButton(new Photo("PicturesElements/gallery.png"));
	private ApplicationButton btnAutres = new ApplicationButton(new Photo("PicturesElements/unknown.png"));
	private ApplicationButton btnSettings = new ApplicationButton(new Photo("PicturesElements/settings.png"));

	private MainPanelGalerie galerie = new MainPanelGalerie(panelApplication);
	private Contact_Carnet carnet;

	public Launcher() {

		// Préferences de la frame principale
		// setUndecorated(false);
		setPreferredSize(new Dimension(480, 800));
		setSize(480, 800);
		setLocationRelativeTo(null);
		setResizable(false);
//		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ajout des actionlistener sur les boutons
		btnGalerie.addActionListener(new Galerie_Click());
		btnContacts.addActionListener(new Contact_Click());

		// ajout des boutons à la frame
		panelApplication.add(btnContacts);
		panelApplication.add(btnGalerie);
		panelApplication.add(btnAutres);
		panelApplication.add(btnSettings);

		// create the border
		createBorder();

		// modification du bouton home et ajout au southLayout
		homeButton.addActionListener(new Home_Click());
		south.add(homeButton);

		// ajout de mes panels pour cardLayout
		mainContainer.setLayout(c1);
		mainContainer.add(panelApplication, "panelApplications");
		c1.show(mainContainer, "panelLauncher");

		// ajout de tout mes panels à la frame
		add(topBar, BorderLayout.NORTH);
		add(est, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(mainContainer);

		pack();

	}

	public void createBorder() {
		west.setPreferredSize(new Dimension(25, 100));
		west.setBackground(Color.BLACK);

		est.setPreferredSize(new Dimension(25, 100));
		est.setBackground(Color.BLACK);

		south.setBackground(Color.BLACK);
		flSouth.setAlignment(flSouth.CENTER);
		south.setLayout(flSouth);
	}

	class Home_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.show(mainContainer, "panelApplications");
		}

	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainContainer.add(galerie, "galerie");
			c1.show(mainContainer, "galerie");
		}

	}

	class Contact_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			carnet = new Contact_Carnet();
			mainContainer.add(carnet, "carnet");
			c1.show(mainContainer, "carnet");

		}
	}

	class Settings_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
