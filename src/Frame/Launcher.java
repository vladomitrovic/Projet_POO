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
	public CardLayout cardLayout = new CardLayout();
	private JPanel panelContainer = new JPanel();
	private JPanel panelLauncher = new JPanel();

	public Launcher() {

		// Préferences de la frame principale
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panelLauncher.setLayout(null);
		panelContainer.setLayout(cardLayout);

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

		// ajout des panel au panelContainer puis show avec cardLayout
		panelContainer.add(panelLauncher, "panelLauncher");
		cardLayout.show(panelContainer, "panelLauncher");

		//add panelContainer to JFrame
		add(panelContainer);

		pack();

	}

	public JPanel getPanelContainer() {
		return panelContainer;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(Object show, String name) {
		cardLayout.show((Container) show, name);
	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MainFrmGalerie frmGalerie = new MainFrmGalerie();
			panelContainer.add(frmGalerie.getPrincipalPanel(), "principalPanel");
			cardLayout.show(panelContainer, "principalPanel");
		}

	}

}
