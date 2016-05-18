package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


import Contact.CarnetContact;
import Contact.Contact;
import Frame.MainPanelGalerie.PhotoPanel;
import Galerie.Photo;

public class MainPanelCarnet extends JPanel {

	JPanel mainCarnet = new JPanel();

	
	CarnetContact carnet=new CarnetContact();
	

	Contact vlado = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john = new Contact("Doe", "John", "079 123 45 67");
	Contact adam = new Contact("Adam", "Smith", "078 765 41 23");

	JLabel noContact = new JLabel();
	
	private TopBarPanel topBar;
	private JPanel top;

	public MainPanelCarnet(JPanel top) {
		this.setLayout(new BorderLayout());
		this.top=top;
		topBar = new TopBarPanel(MainPanelCarnet.this,top);
		add(topBar, BorderLayout.NORTH);
		setPreferredSize(new Dimension(480, 800));
		
		GridLayout grid=new GridLayout(10, 1);
		grid.setVgap(10);
		mainCarnet.setLayout(grid);
		add(mainCarnet);

		carnet.getCarnet().add(adam);
		carnet.getCarnet().add(john);
		carnet.getCarnet().add(vlado);
		
	

		// afficher contact
		for (Contact c : carnet.getCarnet()) {
			mainCarnet.add(new JButton(c.getNom() + " " + c.getPrenom()));
		}

		


	}

	class ContactPanel extends JPanel {

		private Contact contact;
		private JPanel details = new JPanel(new GridLayout(10, 1));

		public ContactPanel(Contact contact) {
			this.contact = contact;
			details.add(new JLabel(contact.getNom()));
			details.add(new JLabel(contact.getPrenom()));
			details.add(new JLabel(contact.getTel()));

		}

	}

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainCarnet.setVisible(false);
			JButton button = (JButton) e.getSource();
			// Contact contact = (Contact) button.;
			// add(new ContactPanel(contact));

		}



	}

}
